package com.github.gomelon.ideakit.meta;

import com.goide.psi.GoFieldDeclaration;
import com.goide.psi.GoFieldDefinition;
import com.goide.psi.GoFile;
import com.goide.psi.GoSpecType;
import com.goide.psi.GoStructType;
import com.goide.psi.GoType;
import com.goide.psi.GoTypeSpec;
import com.goide.vgo.mod.psi.VgoFile;
import com.goide.vgo.mod.psi.VgoModuleSpec;
import com.goide.vgo.mod.psi.VgoRequireDirective;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectLocator;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReference;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DeclarationParser {

    private static final DeclarationParser INSTANCE = new DeclarationParser();

    public static DeclarationParser getInstance() {
        return INSTANCE;
    }

    public static String getQualifyName(String text) {
        text = text.trim();
        if (StringUtils.indexOf(text, '+') != 0 || text.length() == 1) {
            return "";
        }
        String[] parts = org.apache.commons.lang3.StringUtils.split(text.substring(1).trim(), " ", 2);
        if (parts.length == 0) {
            return "";
        }
        return parts[0];
    }

    public Collection<Declaration> parse(Document document) {
        VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(document);
        return parse(virtualFile, document);
    }

    public Collection<Declaration> parse(VirtualFile virtualFile) {
        Document document = FileDocumentManager.getInstance().getDocument(virtualFile);
        return parse(virtualFile, document);
    }

    public Collection<Declaration> parse(VgoFile vgoFile) {
        List<Declaration> result = new LinkedList<>();
        for (PsiElement element : vgoFile.getChildren()) {
            if (!(element instanceof VgoRequireDirective)) {
                continue;
            }
            VgoRequireDirective requireDirective = (VgoRequireDirective) element;
            result.addAll(parseVgoRequire(requireDirective));
        }
        return result;
    }

    public Collection<Declaration> parse(GoFile goFile) {
        VirtualFile virtualFile = goFile.getVirtualFile();
        if (virtualFile == null) {
            return Collections.emptyList();
        }
        return innerParseGoFile(goFile);
    }

    private Collection<Declaration> parse(VirtualFile virtualFile, Document document) {
        if (virtualFile == null || document == null) {
            return Collections.emptyList();
        }
        String fileTypeDisplayName = virtualFile.getFileType().getDisplayName();
        if (fileTypeDisplayName.endsWith("_test.go")) {
            return Collections.emptyList();
        }
        if ((!"go".equalsIgnoreCase(fileTypeDisplayName)
                && CommentUtils.maybeMetaDeclaration(document.getText()))
                && !"vgo".equals(fileTypeDisplayName)) {
            return Collections.emptyList();
        }

        Project project = ProjectLocator.getInstance().guessProjectForFile(virtualFile);
        if (project == null) {
            return Collections.emptyList();
        }

        PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);
        if (psiFile == null) {
            return Collections.emptyList();
        }
        if (psiFile instanceof GoFile) {
            GoFile goFile = (GoFile) psiFile;
            return parse(goFile);
        } else if (psiFile instanceof VgoFile) {
            VgoFile vgoFile = (VgoFile) psiFile;
            return parse(vgoFile);
        }
        return Collections.emptyList();
    }

    private Collection<Declaration> parseVgoRequire(VgoRequireDirective requireDirective) {
        List<Declaration> result = new LinkedList<>();
        List<VgoModuleSpec> moduleSpecList = requireDirective.getModuleSpecList();
        for (VgoModuleSpec vgoModuleSpec : moduleSpecList) {
            result.addAll(parseVgoModule(vgoModuleSpec));
        }
        return result;
    }

    private Collection<Declaration> parseVgoModule(VgoModuleSpec vgoModuleSpec) {
        //github.com/Masterminds/goutils v1.1.1 // indirect
        //references[0]=github.com
        //references[1]=Masterminds
        //references[2]=goutils
        FileReference[] references = vgoModuleSpec.getReferences();
        if (references.length == 0) {
            return Collections.emptyList();
        }

        FileReference lastReference = references[references.length - 1];
        // 以indirect结尾,但模块名又不叫indirect的
        String text = vgoModuleSpec.getText();
        if (!text.startsWith("github.com/gomelon/meta")
                && text.endsWith("indirect")
                && !lastReference.getText().endsWith("indirect")) {
            return Collections.emptyList();
        }

        ResolveResult[] resolveResults = lastReference.multiResolve(true);
        if (resolveResults.length == 0) {
            return Collections.emptyList();
        }

        PsiElement resolvedVgoModule = resolveResults[0].getElement();
        if (resolvedVgoModule == null) {
            return Collections.emptyList();
        }

        List<Declaration> result = new LinkedList<>();
        PsiElement[] children = resolvedVgoModule.getChildren();
        for (PsiElement child : children) {
            result.addAll(parseFileOrDirectory(child));
        }
        return result;
    }

    private Collection<Declaration> parseFileOrDirectory(PsiElement element) {
        if (element instanceof GoFile) {
            GoFile goFile = (GoFile) element;
            return innerParseGoFile(goFile);
        } else if (element instanceof PsiDirectory) {
            PsiDirectory goDirectory = (PsiDirectory) element;
            PsiElement[] children = goDirectory.getChildren();
            List<Declaration> result = new LinkedList<>();
            for (PsiElement child : children) {
                result.addAll(parseFileOrDirectory(child));
            }
            return result;
        }
        return Collections.emptyList();
    }

    private Collection<Declaration> innerParseGoFile(GoFile goFile) {
        if (goFile.getName().endsWith("_test.go")) {
            return Collections.emptyList();
        }
        List<Declaration> result = new LinkedList<>();
        for (GoTypeSpec goType : goFile.getTypes()) {
            if (!goType.isPublic()) {
                continue;
            }
            Declaration declaration = parseGoType(goFile.getVirtualFile().getPath(), goType);
            if (declaration == null) {
                continue;
            }
            result.add(declaration);
            return result;
        }
        return Collections.emptyList();
    }

    private Declaration parseGoType(String filePath, GoTypeSpec goType) {
        GoSpecType specType = goType.getSpecType();
        if (!(specType.getType() instanceof GoStructType)) {
            return null;
        }
        List<PsiComment> comments = CommentUtils.getComments(goType.getParent());
        String metaComment = CommentUtils.extractMetaDeclaration(comments);
        if (StringUtils.isBlank(metaComment)) {
            return null;
        }
        GoStructType goStructType = (GoStructType) specType.getType();
        Declaration metaDecl = new Declaration();
        metaDecl.setFilePath(filePath);
        metaDecl.setName(goType.getQualifiedName());
        metaDecl.setPsiElement(goType);
        List<Declaration.Field> fields = new ArrayList<>(goStructType.getFieldDefinitions().size());
        metaDecl.setFields(fields);
        for (GoFieldDeclaration oneLineFieldDecl : goStructType.getFieldDeclarationList()) {
            GoType fileGoType = oneLineFieldDecl.getType();
            if (fileGoType == null) {
                continue;
            }
            String goFieldTypeStr = fileGoType.getText();
            DeclarationFieldType type = DeclarationFieldType.from(goFieldTypeStr);
            if (type == null) {
                continue;
            }
            for (GoFieldDefinition goFieldDefinition : oneLineFieldDecl.getFieldDefinitionList()) {
                Declaration.Field field = new Declaration.Field();
                field.setName(goFieldDefinition.getIdentifier().getText());
                field.setPsiElement(goFieldDefinition);
                field.setType(type);
                fields.add(field);
            }
        }
        return metaDecl;
    }
}

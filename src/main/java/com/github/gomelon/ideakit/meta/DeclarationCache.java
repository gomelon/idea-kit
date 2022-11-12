package com.github.gomelon.ideakit.meta;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileVisitor;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class DeclarationCache {

    // File-> QualifyName -> Declaration
    /**
     * declaration from current project
     */
    private final Map<String, Map<String, Declaration>> localFilePathToDeclarations = new HashMap<>();
    /**
     * declaration from dependency project
     */
    private final Map<String, Map<String, Declaration>> vgoFilePathToDeclarations = new HashMap<>();

    private final Map<String, Declaration> qualifyNameToDeclaration = new HashMap<>();

    private final Project project;

    public DeclarationCache(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public synchronized void reload() {
        invalidAll();
        VirtualFile parent = ProjectRootManager.getInstance(project).getContentRoots()[0];
        DeclarationParser declarationParser = DeclarationParser.getInstance();
        VfsUtilCore.visitChildrenRecursively(parent, new VirtualFileVisitor<Void>() {
            @Override
            public boolean visitFile(@NotNull VirtualFile file) {
                if (file.isDirectory()) {
                    return true;
                }
                Collection<Declaration> declarations = declarationParser.parse(file);
                putAll(declarations);
                return false;
            }
        });
    }

    public synchronized void invalidAll() {
        vgoFilePathToDeclarations.clear();
        localFilePathToDeclarations.clear();
        qualifyNameToDeclaration.clear();
    }

    public synchronized void invalidByFilePath(String filePath) {
        Map<String, Declaration> fileDeclarations;
        if (isLocal(filePath)) {
            fileDeclarations = localFilePathToDeclarations.get(filePath);
            localFilePathToDeclarations.remove(filePath);
        } else {
            fileDeclarations = vgoFilePathToDeclarations.get(filePath);
            vgoFilePathToDeclarations.remove(filePath);
        }
        if (fileDeclarations != null) {
            for (String qualifyName : fileDeclarations.keySet()) {
                qualifyNameToDeclaration.remove(qualifyName);
            }
        }
    }

    public synchronized boolean contains(String qualifyName) {
        return qualifyNameToDeclaration.containsKey(qualifyName);
    }

    public synchronized Set<String> getQualifyNames() {
        return qualifyNameToDeclaration.keySet();
    }


    public Collection<Declaration> getAll() {
        return qualifyNameToDeclaration.values();
    }

    public synchronized Optional<Declaration> get(String qualifyName) {
        for (Map<String, Declaration> fileDeclarations : localFilePathToDeclarations.values()) {
            if (fileDeclarations.containsKey(qualifyName)) {
                return Optional.of(fileDeclarations.get(qualifyName));
            }
        }
        for (Map<String, Declaration> fileDeclarations : vgoFilePathToDeclarations.values()) {
            if (fileDeclarations.containsKey(qualifyName)) {
                return Optional.of(fileDeclarations.get(qualifyName));
            }
        }
        return Optional.empty();
    }

    public synchronized void putAll(Collection<Declaration> declarations) {
        for (Declaration declaration : declarations) {
            put(declaration);
        }
    }

    public synchronized void put(Declaration declaration) {
        Map<String, Map<String, Declaration>> filePathToDeclarations;
        if (isLocal(declaration.getFilePath())) {
            filePathToDeclarations = localFilePathToDeclarations;
        } else {
            filePathToDeclarations = vgoFilePathToDeclarations;
        }
        Map<String, Declaration> declarations = localFilePathToDeclarations.get(declaration.getFilePath());
        if (declarations == null) {
            declarations = new HashMap<>();
            filePathToDeclarations.put(declaration.getFilePath(), declarations);
        }
        declarations.put(declaration.getName(), declaration);
        qualifyNameToDeclaration.put(declaration.getName(), declaration);
    }

    private boolean isLocal(String filePath) {
        return StringUtils.startsWith(filePath, project.getBasePath());
    }
}

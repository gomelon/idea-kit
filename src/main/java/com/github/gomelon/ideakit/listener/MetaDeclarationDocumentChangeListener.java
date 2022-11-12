package com.github.gomelon.ideakit.listener;

import com.github.gomelon.ideakit.meta.Declaration;
import com.github.gomelon.ideakit.meta.DeclarationCache;
import com.github.gomelon.ideakit.meta.DeclarationCacheManager;
import com.github.gomelon.ideakit.meta.DeclarationParser;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.event.BulkAwareDocumentListener;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectLocator;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class MetaDeclarationDocumentChangeListener implements BulkAwareDocumentListener {

    @Override
    public void documentChangedNonBulk(@NotNull DocumentEvent event) {
        doChanged(event.getDocument());
    }

    @Override
    public void bulkUpdateFinished(@NotNull Document document) {
        doChanged(document);
    }

    private void doChanged(@NotNull Document document) {
        Collection<Declaration> declarations = DeclarationParser.getInstance().parse(document);
        VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(document);
        if (virtualFile == null) {
            return;
        }
        Project project = ProjectLocator.getInstance().guessProjectForFile(virtualFile);
        if (project == null) {
            return;
        }
        DeclarationCache declarationCache = DeclarationCacheManager.getInstance(project);
        declarationCache.invalidByFilePath(virtualFile.getPath());
        declarationCache.putAll(declarations);
    }
}

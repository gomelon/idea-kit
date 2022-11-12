package com.github.gomelon.ideakit.listener;

import com.github.gomelon.ideakit.meta.Declaration;
import com.github.gomelon.ideakit.meta.DeclarationCache;
import com.github.gomelon.ideakit.meta.DeclarationCacheManager;
import com.github.gomelon.ideakit.meta.DeclarationParser;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectLocator;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileEvent;
import com.intellij.openapi.vfs.VirtualFileListener;
import com.intellij.openapi.vfs.VirtualFileMoveEvent;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Collection;

public class MetaVirtualFileListener implements VirtualFileListener {

    public MetaVirtualFileListener() {
    }

    @Override
    public void fileDeleted(@NotNull VirtualFileEvent event) {
        VirtualFile virtualFile = event.getFile();
        Project project = ProjectLocator.getInstance().guessProjectForFile(virtualFile);
        if (project == null) {
            return;
        }
        DeclarationCacheManager.getInstance(project).invalidByFilePath(virtualFile.getPath());
    }

    @Override
    public void fileMoved(@NotNull VirtualFileMoveEvent event) {
        VirtualFile virtualFile = event.getFile();
        Project project = ProjectLocator.getInstance().guessProjectForFile(virtualFile);
        if (project == null) {
            return;
        }
        String oldFilePath = event.getOldParent().getPath() + File.separator + virtualFile.getName();
        DeclarationCache declarationCache = DeclarationCacheManager.getInstance(project);
        declarationCache.invalidByFilePath(oldFilePath);
        Collection<Declaration> declarations = DeclarationParser.getInstance().parse(virtualFile);
        declarationCache.putAll(declarations);
    }
}

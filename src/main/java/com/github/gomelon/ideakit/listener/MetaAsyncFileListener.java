package com.github.gomelon.ideakit.listener;

import com.github.gomelon.ideakit.meta.Declaration;
import com.github.gomelon.ideakit.meta.DeclarationCache;
import com.github.gomelon.ideakit.meta.DeclarationCacheManager;
import com.github.gomelon.ideakit.meta.DeclarationParser;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectLocator;
import com.intellij.openapi.vfs.AsyncFileListener;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public class MetaAsyncFileListener implements AsyncFileListener {

    @Override
    public @Nullable ChangeApplier prepareChange(@NotNull List<? extends VFileEvent> events) {
        return new MetaChangeApplier(events);
    }

    public static class MetaChangeApplier implements ChangeApplier {

        private final List<? extends VFileEvent> events;

        public MetaChangeApplier(List<? extends VFileEvent> events) {
            this.events = events;
        }

        @Override
        public void beforeVfsChange() {
        }

        @Override
        public void afterVfsChange() {
            ApplicationManager.getApplication().executeOnPooledThread(() ->
                    ApplicationManager.getApplication().runReadAction(() -> {
                        for (VFileEvent event : events) {
                            VirtualFile virtualFile = event.getFile();
                            if (virtualFile == null) {
                                continue;
                            }
                            Collection<Declaration> declarations = DeclarationParser.getInstance().parse(virtualFile);
                            Project project = ProjectLocator.getInstance().guessProjectForFile(virtualFile);
                            if (project == null) {
                                return;
                            }
                            DeclarationCache declarationCache = DeclarationCacheManager.getInstance(project);
                            declarationCache.invalidByFilePath(virtualFile.getPath());
                            declarationCache.putAll(declarations);
                        }
                    })
            );
        }
    }
}

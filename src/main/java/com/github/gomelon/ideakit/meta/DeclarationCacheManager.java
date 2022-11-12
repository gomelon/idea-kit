package com.github.gomelon.ideakit.meta;

import com.intellij.openapi.project.Project;

import java.util.ArrayList;
import java.util.List;

public class DeclarationCacheManager {

    private static final List<DeclarationCache> caches = new ArrayList<>();

    public synchronized static DeclarationCache getInstance(Project project) {
        if (project.getBasePath() == null) {
            return new DeclarationCache(project);
        }
        for (DeclarationCache cache : caches) {
            if (project.getBasePath().equals(cache.getProject().getBasePath())) {
                return cache;
            }
        }
        DeclarationCache cache = new DeclarationCache(project);
        cache.reload();
        caches.add(cache);
        return cache;
    }
}

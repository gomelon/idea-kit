package com.github.gomelon.ideakit.listener;

import com.intellij.openapi.vfs.impl.BulkVirtualFileListenerAdapter;

public class MetaBulkFileListener extends BulkVirtualFileListenerAdapter {
    public MetaBulkFileListener() {
        super(new MetaVirtualFileListener());
    }
}

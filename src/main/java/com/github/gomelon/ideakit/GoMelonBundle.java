package com.github.gomelon.ideakit;

import com.intellij.AbstractBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

public class GoMelonBundle extends AbstractBundle {

    public static final String BUNDLE = "messages.GoMelonBundle";

    public static final GoMelonBundle INSTANCE = new GoMelonBundle();

    private GoMelonBundle() {
        super(BUNDLE);
    }

    @NotNull
    @Override
    public String getMessage(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, @NotNull Object... params) {
        return super.getMessage(key, params);
    }
}

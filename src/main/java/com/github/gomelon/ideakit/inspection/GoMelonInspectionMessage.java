package com.github.gomelon.ideakit.inspection;

import com.github.gomelon.ideakit.GoMelonBundle;
import com.goide.inspections.core.GoInspectionMessage;
import org.jetbrains.annotations.PropertyKey;

public class GoMelonInspectionMessage implements GoInspectionMessage {

    private final String message;

    public GoMelonInspectionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public static GoInspectionMessage message(
            @PropertyKey(resourceBundle = "messages.GoMelonBundle") String key,
            Object... parameters) {
        String message = GoMelonBundle.INSTANCE.getMessage(key, parameters);
        return new GoMelonInspectionMessage(message);
    }
}

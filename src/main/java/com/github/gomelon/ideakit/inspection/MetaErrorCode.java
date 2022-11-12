package com.github.gomelon.ideakit.inspection;

public enum MetaErrorCode {
    INPUT_MISMATCH,
    UNKNOWN_FIELD("go.inspection.meta.problem.unknown.field"),
    DUPLICATE_FIELD("go.inspection.meta.problem.duplicate.field"),
    INVALID_FIELD_VALUE,

    ;

    private final String problemCode;

    MetaErrorCode() {
        this("");
    }

    MetaErrorCode(String problemCode) {
        this.problemCode = problemCode;
    }

    public String getProblemCode() {
        return problemCode;
    }
}

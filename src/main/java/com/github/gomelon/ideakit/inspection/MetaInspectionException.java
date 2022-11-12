package com.github.gomelon.ideakit.inspection;

public class MetaInspectionException extends RuntimeException {

    private final int startIndex;
    private final int stopIndex;
    private final MetaErrorCode errorCode;

    public MetaInspectionException(MetaErrorCode errorCode) {
        this(0, 0, errorCode, "");
    }

    public MetaInspectionException(int startIndex, int stopIndex, MetaErrorCode errorCode, String message) {
        super(message);
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.errorCode = errorCode;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public MetaErrorCode getErrorCode() {
        return errorCode;
    }
}

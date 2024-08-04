package io.github.edsonzuchi.warehouse.util;

public class UseCaseException extends Exception {
    public UseCaseException() {
        super();
    }

    public UseCaseException(String message) {
        super(message);
    }

    public UseCaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public UseCaseException(Throwable cause) {
        super(cause);
    }

    protected UseCaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

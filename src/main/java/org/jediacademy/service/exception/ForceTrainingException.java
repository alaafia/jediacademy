package org.jediacademy.service.exception;

public class ForceTrainingException extends RuntimeException {
    public ForceTrainingException(String message) {
        super(message);
    }

    public ForceTrainingException(String message, Throwable cause) {
        super(message, cause);
    }
}

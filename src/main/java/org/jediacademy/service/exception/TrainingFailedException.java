package org.jediacademy.service.exception;

public class TrainingFailedException extends ForceTrainingException {
    public TrainingFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}

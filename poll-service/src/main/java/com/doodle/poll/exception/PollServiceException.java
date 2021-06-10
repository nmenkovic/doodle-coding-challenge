package com.doodle.poll.exception;

public abstract class PollServiceException extends RuntimeException {

    public PollServiceException() {
    }

    public PollServiceException(String message) {
        super(message);
    }

    public PollServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

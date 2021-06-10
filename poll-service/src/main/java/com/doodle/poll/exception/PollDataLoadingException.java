package com.doodle.poll.exception;

public class PollDataLoadingException extends PollServiceException {

    public PollDataLoadingException() {
    }

    public PollDataLoadingException(String message) {
        super(message);
    }

    public PollDataLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}

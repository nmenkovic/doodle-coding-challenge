package com.doodle.poll.exception;

public class PollCreationException extends PollServiceException {

    public PollCreationException() {
    }

    public PollCreationException(String message) {
        super(message);
    }

    public PollCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}

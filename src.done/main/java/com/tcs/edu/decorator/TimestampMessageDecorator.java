package com.tcs.edu.decorator;

import java.time.Instant;

public class TimestampMessageDecorator {
    public String decorate(String message) {
        final var decoratedMessage = Instant.now() + " " + message;
        return decoratedMessage;
    }
}

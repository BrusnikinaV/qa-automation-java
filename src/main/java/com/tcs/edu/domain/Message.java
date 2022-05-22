package com.tcs.edu.domain;

import com.tcs.edu.enums.Severity;

public class Message {
    private Severity level;
    private String body;

    public Message(Severity level, String body) {
        this.level = level;
        this.body = body;
    }

    public Severity getLevel() {
        return level;
    }

    public String getBody() {
        return body;
    }

    public void setLevel(Severity level) {
        this.level = level;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

package com.tcs.edu.domain;

import com.tcs.edu.enums.Severity;

import java.util.Objects;
import java.util.UUID;

public class Message {
    private UUID id;
    private Severity level;
    private String body;

    public Message( Severity level, String body) {
        this.id = UUID.randomUUID();
        this.level = level;
        this.body = body;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
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

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        } else {
            if (obj != null && obj.getClass() == this.getClass()){
                Message mesObj = (Message) obj;
                return Objects.equals(this.id, mesObj.id);
            } else {
                return false;
            }
        }
    }
}

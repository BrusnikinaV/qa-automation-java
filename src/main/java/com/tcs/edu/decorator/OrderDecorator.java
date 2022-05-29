package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Severity;

public class OrderDecorator implements DecorateMessage {
    @Override
    public Message[] decorate(Message[] uniqueStrings) {
        Message[] descStrings = new Message[uniqueStrings.length];
        for (int i = uniqueStrings.length -1; i>=0; i--) {
            if (uniqueStrings[i] != null){
                descStrings[uniqueStrings.length-i -1] = uniqueStrings[i];
            }
        }
        return descStrings;
    }

    @Override
    public void isArgsValid(Severity level, String message, String... messages) {
        if (level == null) throw new IllegalArgumentException("Аргумент level не может быть null");
        if (message == null) throw new IllegalArgumentException("Не передан message");
        for (var currentMessage:messages){
            if (currentMessage == null) throw new IllegalArgumentException("Не передан message");
        }
    }
}

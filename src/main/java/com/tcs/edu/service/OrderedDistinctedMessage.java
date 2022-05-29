package com.tcs.edu.service;

import com.tcs.edu.decorator.DecorateMessage;
import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Severity;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OrderedDistinctedMessage implements DecorateMessage {
    @Override
    public Message[] decorate(Message[] messages) {
        Message[] uniqueTmpMessages = new Message[messages.length];
        int i = 0;
        for (Message currentMessage:messages){
            boolean unique = true;
            for (var currentUniqueString:uniqueTmpMessages){
                if (currentUniqueString != null && currentMessage.getBody().equals(currentUniqueString.getBody()) &&
                        currentMessage.getLevel().equals(currentMessage.getLevel())){
                    unique = false;
                    break;
                }
            }
            if (unique) {
                uniqueTmpMessages[i] = currentMessage;
                i++;
            }
        }
        Message[] uniqueMessages = new Message[i];
        System.arraycopy(uniqueTmpMessages, 0, uniqueMessages, 0, i);
        return uniqueMessages;
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

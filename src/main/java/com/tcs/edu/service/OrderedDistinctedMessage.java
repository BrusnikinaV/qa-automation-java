package com.tcs.edu.service;

import com.tcs.edu.decorator.DecorateMessage;
import com.tcs.edu.enums.Severity;

public class OrderedDistinctedMessage implements DecorateMessage {
    @Override
    public String[] decorate(String[] messages) {
        String[] uniqueString = new String[1 + messages.length];
        int i = 0;
        for (String currentMessage:messages){
            boolean unique = true;
            if (currentMessage != null){
                for (var currentUniqueString:uniqueString){
                    if (currentMessage.equals(currentUniqueString)){
                        unique = false;
                        break;
                    }
                }
                if (unique) {
                    uniqueString[i] = currentMessage;
                    i++;
                }
            }
        }
        return uniqueString;
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

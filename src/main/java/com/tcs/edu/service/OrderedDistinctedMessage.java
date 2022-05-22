package com.tcs.edu.service;

import com.tcs.edu.decorator.DecorateMessage;

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
}

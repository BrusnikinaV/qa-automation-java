package com.tcs.edu.decorator;

public class OrderedDistinctedMessageService implements DecorateMessageService {
    @Override
    public String[] decorate(String[] messages) {
        String[] uniqueString = new String[1 + messages.length];
        int k = 0;
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
                    uniqueString[k] = currentMessage;
                    k++;
                }
            }
        }
        return uniqueString;
    }
}

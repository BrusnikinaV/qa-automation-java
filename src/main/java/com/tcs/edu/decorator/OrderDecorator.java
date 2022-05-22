package com.tcs.edu.decorator;

public class OrderDecorator implements DecorateMessage {
    @Override
    public String[] decorate(String[] uniqueStrings) {
        String[] descStrings = new String[uniqueStrings.length];
        for (int i = uniqueStrings.length -1; i>=0; i--) {
            if (uniqueStrings[i] != null){
                descStrings[uniqueStrings.length-i -1] = uniqueStrings[i];
            }
        }
        return descStrings;
    }
}

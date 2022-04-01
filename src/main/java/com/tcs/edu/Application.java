package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;

class Application {
    public static void main(String[] args) {
        System.out.println(TimestampMessageDecorator.decorate("Hello world"));
    }
}
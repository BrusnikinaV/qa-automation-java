package com.tcs.edu;

import static com.tcs.edu.decorator.TimestampMessageDecorator.*;

class Application {
    public static void main(String[] args) {
        System.out.println(decorator(" Hello world"));
    }
}
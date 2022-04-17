package com.tcs.edu;

import com.tcs.edu.decorator.MessageService;
import com.tcs.edu.decorator.enumDecorator.Severity;

class Application {
    public static void main(String[] args) {
        System.out.println(MessageService.decorate("Hello world", Severity.MINOR));
        System.out.println(MessageService.decorate("Hello world", Severity.REGULAR));
        System.out.println(MessageService.decorate("Hello world", Severity.MAJOR));
        System.out.println(MessageService.decorate("Hello world", Severity.MINOR));
        System.out.println(MessageService.decorate("Hello world", Severity.REGULAR));
        System.out.println(MessageService.decorate("Hello world", Severity.MAJOR));

    }
}
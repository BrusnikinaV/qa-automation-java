package com.tcs.edu;

import com.tcs.edu.decorator.MessageService;
import com.tcs.edu.enums.Severity;

class Application {
    public static void main(String[] args) {
        MessageService.print(Severity.MINOR, "Hello world!");
        MessageService.print(Severity.REGULAR, "Hi!", "Hello world", "Hello");
        MessageService.print(Severity.MAJOR, "Hello");
    }
}
package com.tcs.edu;

import com.tcs.edu.decorator.MessageService;
import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Doubling;
import com.tcs.edu.enums.MessageOrder;
import com.tcs.edu.enums.Severity;

class Application {
    public static void main(String[] args) {
        MessageService.print(Severity.MINOR, "Hello world!");
        MessageService.print(Severity.REGULAR, MessageOrder.ASC, Doubling.DOUBLES,
                "Hi!", "Hello world", "Hello world", "Hello world", "Hello", null);
        MessageService.print(
                Severity.MAJOR, MessageOrder.DESC, Doubling.DISTINCT, "Hello",
                "Hello", "Hello", "Hello", "Hello", "Hi", "abs");
        MessageService.print(
                Severity.MAJOR, MessageOrder.ASC, Doubling.DISTINCT, "Hello",
                "Hello", "Hello", "Hello", "Hello", "Hi", "abs");
        MessageService.print(new Message(Severity.MAJOR, "Hello beautiful world"), "m1", "m2");
    }
}
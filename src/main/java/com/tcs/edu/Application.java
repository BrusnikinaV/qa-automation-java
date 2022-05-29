package com.tcs.edu;

import com.tcs.edu.enums.Doubling;
import com.tcs.edu.enums.MessageOrder;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.service.MessageService;

class Application {
    public static void main(String[] args) {
        MessageService messageService = new MessageService();
        System.out.println("Выводится 1 минорное сообщение:");
        messageService.print(Severity.MINOR, "Hello world!");
        System.out.println("Выводится 6 собщений: ");
        messageService.print(Severity.REGULAR, MessageOrder.ASC, Doubling.DOUBLES,
                "Hi!", "Hello world", "Hello world", "Hello world", "Hello", null);
        System.out.println("Выводится 3 сообщения, отсортированных по возрастанию. Удалены дубли :");
        messageService.print(
                Severity.MAJOR, MessageOrder.DESC, Doubling.DISTINCT, "Hello",
                "Hello", "Hello", "Hello", "Hello", "Hi", "abs");
        System.out.println("Выводится 3 сообщения, не отсортированных по возрастанию. Удалены дубли :");
        messageService.print(
                Severity.MAJOR, MessageOrder.ASC, Doubling.DISTINCT, "Hello",
                "Hello", "Hello", "Hello", "Hello", "Hi", "abs");
        System.out.println("Выводится 3 сообщения:");
        messageService.print(new com.tcs.edu.domain.Message(Severity.MAJOR, "Hello beautiful world"), "m1", "m2");
    }
}
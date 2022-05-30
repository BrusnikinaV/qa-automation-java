package com.tcs.edu;

import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Doubling;
import com.tcs.edu.enums.MessageOrder;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.service.MessageService;

import java.util.UUID;

class Application {
    public static void main(String[] args) {
        MessageService messageService = new MessageService();
        messageService.print(Severity.MINOR, "Hello world!");
        messageService.print(Severity.REGULAR, MessageOrder.ASC, Doubling.DOUBLES,
                "Hi!", "Hello world", "Hello world", "Hello world", "Hello", null);
        messageService.print(
                Severity.MAJOR, MessageOrder.DESC, Doubling.DISTINCT, "Hello",
                "Hello", "Hello", "Hello", "Hello", "Hi", "abs");
        messageService.print(
                Severity.MAJOR, MessageOrder.ASC, Doubling.DISTINCT, "Hello",
                "Hello", "Hello", "Hello", "Hello", "Hi", "abs");
        messageService.print(new Message(Severity.MAJOR, "Hello beautiful world"), "m1", "m2");
        var messageCollection = messageService.findAll();
        messageService.findByPrimaryKey(messageCollection.stream().findFirst().get().getId());
        for (var currentMes:messageCollection){
            System.out.println(currentMes.getBody());
        }
        var filterMessageService = messageService.findBySeverity(Severity.MAJOR);
        for (var currentMes:filterMessageService){
            System.out.println(currentMes.getBody());
        }
    }
}
package com.tcs.edu.service;

import com.tcs.edu.decorator.DecorateMessage;
import com.tcs.edu.decorator.OrderDecorator;
import com.tcs.edu.decorator.PageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Doubling;
import com.tcs.edu.enums.MessageOrder;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.printer.Printer;

/**
 * Класс, описывающий методы получения итоговых строк
 * @author Брусникина Варвара
 */
public class MessageService {
    /**
     * Вывод в консоль сообщений, сформированных для каждого переданного в массиве message
     * @param level уровень важности
     * @param message Строка, которую необходимо вывести на консоль
     * @param messages Массив строк, каждую из которых необходимо вывести на консоль
     */
    DecorateMessage distincted = new OrderedDistinctedMessage();
    DecorateMessage decorateMessageService = new OrderDecorator();
    Printer consolePrinter = new ConsolePrinter();
    PageDecorator pageDecorator = new PageDecorator();

    public void print(Severity level, String message, String... messages){
        try {
            print(level, MessageOrder.ASC, Doubling.DOUBLES, message, messages);
        }
        catch (IllegalArgumentException e){
            throw new LogException("Не удалось напечатать сообщение", e);
        }
    }

    public void print(Message message, String... messages){
        try {
            print(message.getLevel(), MessageOrder.ASC, Doubling.DOUBLES, message.getBody(), messages);
        }
        catch (IllegalArgumentException e){
            throw new LogException("Не удалось напечатать сообщение", e);
        }
    }

    public void print(Severity level, MessageOrder order, Doubling doubling, String message, String... messages){
        String[] strings = new String[1 + messages.length];
        strings[0] = message;
        for (int i=0; i<messages.length; i++){
            strings[i+1] = messages[i];
        }
        if (doubling.equals(Doubling.DISTINCT)){
            distincted.isArgsValid(level, message, messages);
            strings = distincted.decorate(strings);
        }
        if (order.equals(MessageOrder.DESC)) {
            decorateMessageService.isArgsValid(level, message, messages);
            strings = decorateMessageService.decorate(strings);
        }
        for (String currentMessage:strings) {
            pageDecorator.isArgsValid(level, message, messages);
            consolePrinter.print(pageDecorator.decorate(currentMessage, level));
        }
    }
}

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

    public void print(Severity level, String message, String... messages){
        print(level, MessageOrder.ASC, Doubling.DOUBLES, message, messages);
    }

    public void print(Message message, String... messages){
        print(message.getLevel(), MessageOrder.ASC, Doubling.DOUBLES, message.getBody(), messages);
    }

    public void print(Severity level, MessageOrder order, Doubling doubling, String message, String... messages){
        if (level == null && message == null)
            return;
        String[] strings = new String[1 + messages.length];
        strings[0] = message;
        for (int i=0; i<messages.length; i++){
            strings[i+1] = messages[i];
        }
        if (doubling.equals(Doubling.DISTINCT)){
            strings = distincted.decorate(strings);
        }
        if (order.equals(MessageOrder.DESC)) {
            strings = decorateMessageService.decorate(strings);
        }
        for (String currentMessage:strings) {
            if (currentMessage != null) {
                consolePrinter.print(new PageDecorator().decorate(currentMessage, level));
            }
        }
    }
}

package com.tcs.edu.decorator;

import com.tcs.edu.enums.MessageOrder;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.printer.ConsolePrinter;

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

    public static void print(Severity level, String message, String... messages){
        print(level, MessageOrder.ASC, message, messages);
    }

    public static void print(Severity level, MessageOrder order, String message, String... messages){
        if (order.equals(MessageOrder.ASC)){
            ConsolePrinter.print(MessageDecorate.decorate(message, level));
            for (String currentMessage:messages){
                if (currentMessage != null & level != null & message != null){
                    ConsolePrinter.print(MessageDecorate.decorate(currentMessage, level));
                }
            }
        } else {
            for (int i = messages.length -1; i>=0; i--) {
                if (messages[i] != null & level != null){
                    ConsolePrinter.print(MessageDecorate.decorate(messages[i], level));
                }
            }
        }

    }
}

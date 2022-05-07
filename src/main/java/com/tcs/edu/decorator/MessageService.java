package com.tcs.edu.decorator;

import com.tcs.edu.enums.Doubling;
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
        print(level, MessageOrder.ASC, Doubling.DOUBLES, message, messages);
    }

    public static void print(Severity level, MessageOrder order, Doubling doubling, String message, String... messages){
        if (level == null && message == null)
            return;
        String[] strings = new String[1 + messages.length];
        strings[0] = message;
        for (int i=0; i<messages.length; i++){
            strings[i+1] = messages[i];
        }
        if (doubling.equals(Doubling.DISTINCT)){
            strings = OrderedDistinctedMessageService.orderedDistinct(strings);
        }
        if (order.equals(MessageOrder.DESC)) {
            strings = DirectionMessageService.orderByDesc(strings);
        }
        for (String currentMessage:strings) {
            if (currentMessage != null) {
                ConsolePrinter.print(MessageDecorate.decorate(currentMessage, level));
            }
        }
    }
}

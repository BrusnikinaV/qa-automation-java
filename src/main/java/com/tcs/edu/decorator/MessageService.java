package com.tcs.edu.decorator;

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
        ConsolePrinter.print(MessageDecorate.decorate(message, level));
        for (String currentMessage:messages){
            if (currentMessage != null){
                ConsolePrinter.print(MessageDecorate.decorate(currentMessage, level));
            }
        }
    }
}

package com.tcs.edu.decorator;

import com.tcs.edu.decorator.enumDecorator.Severity;
import com.tcs.edu.decorator.enumDecorator.SeverityDecorate;

import java.time.Instant;

/**
 * Класс, описывающий методы формирования строк.
 * @author Брусникина Варвара
 */
public class MessageDecorate {
    static Integer messageCount = 0;
    static Integer PAGE_SIZE = 2;
    /**
     * Формирование строки вида  - номер строки текущая дата и время + строка + уровень важности
     * @param message Сообщение, которое необходимо добавить к текущей дате и времени
     * @return Сформированная строка по  шаблону
     */
    public static String decorate(String message, Severity level){
        messageCount++;
        if (messageCount % PAGE_SIZE == 0){
            return String.format(
                    "%d %s %s %s\n%s", messageCount, Instant.now(), message, SeverityDecorate.enumToString(level), "---");
        }else{
            return String.format("%d %s %s %s", messageCount, Instant.now(), message, SeverityDecorate.enumToString(level));
        }
    }
}

package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Класс, описывающий методы формирования строк.
 * @author Брусникина Варвара
 */
public class TimestampMessageDecorator {
    static Integer messageCount = 0;
    static Integer PAGE_SIZE = 2;
    /**
     * Формирование строки вида  - номер строки текущая дата и время + строка
     * @param message Сообщение, которое необходимо добавить к текущей дате и времени
     * @return Сформированная строка по  шаблону
     */
    public static String decorate(String message){
        messageCount++;
        if (messageCount % PAGE_SIZE == 0){
            return String.format("%d %s %s \n%s", messageCount, Instant.now(), message, "---");
        }else{
            return String.format("%d %s %s", messageCount, Instant.now(), message);
        }
    }
}

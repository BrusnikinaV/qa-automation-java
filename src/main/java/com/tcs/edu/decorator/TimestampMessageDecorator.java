package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Класс, описывающий методы формирования строк.
 * @author Брусникина Варвара
 */
public class TimestampMessageDecorator {
    static Integer messageCount = 0;
    /**
     * Формирование строки вида  - текущая дата и время + строка
     * @param message Сообщение, которое необходимо добавить к текущей дате и времени
     * @return Склейка текущий даты со временем и строки, полученной извне
     */
    public static String decorate(String message){
        messageCount++;
        String decoratedMessage =  messageCount + " " + Instant.now() + " " + message;
        return decoratedMessage;
    }
}

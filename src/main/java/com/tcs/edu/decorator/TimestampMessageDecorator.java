package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Класс, описывающий методы формирования строк.
 * @author Брусникина Варвара
 */
public class TimestampMessageDecorator {
    /**
     * Формирование строки вида  - текущая дата и время + строка
     * @param message
     * @return Склейка текущий даты со временем и строки, полученной извне
     */
    public static String decorator(String message){
        return Instant.now() + message;
    }
}

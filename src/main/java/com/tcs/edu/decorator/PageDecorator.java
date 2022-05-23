package com.tcs.edu.decorator;

import com.tcs.edu.decorator.enumDecorator.SeverityDecorate;
import com.tcs.edu.enums.Severity;

import java.time.Instant;

/**
 * Класс, описывающий методы формирования строк.
 * @author Брусникина Варвара
 */
public class PageDecorator implements DecorateMessage{
    Integer messageCount = 0;
    Integer PAGE_SIZE = 2;
    /**
     * Формирование строки вида  - номер строки текущая дата и время + строка + уровень важности
     * @param message Сообщение, которое необходимо добавить к текущей дате и времени
     * @return Сформированная строка по  шаблону
     */
    public String decorate(String message, Severity level){
        messageCount++;
        if (messageCount % PAGE_SIZE == 0){
            return String.format(
                    "%d %s %s %s\n%s", messageCount, Instant.now(), message, SeverityDecorate.enumToString(level), "---");
        }else{
            return String.format("%d %s %s %s", messageCount, Instant.now(), message, SeverityDecorate.enumToString(level));
        }
    }

    @Override
    public String[] decorate(String[] strings) {
        return new String[0];
    }

    @Override
    public void isArgsValid(Severity level, String message, String... messages) {
        if (level == null) throw new IllegalArgumentException("Аргумент level не может быть null");
        if (message == null) throw new IllegalArgumentException("Не передан message");
    }
}

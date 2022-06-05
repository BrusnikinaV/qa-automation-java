package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
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
     * @param messages Сообщение, которое необходимо добавить к текущей дате и времени
     */
    @Override
    public Message[] decorate(Message[] messages){
        messageCount++;
        Message[] decoratedMessages = new Message[messages.length];
        int i =0;
        for (var message : messages){
            if (messageCount % PAGE_SIZE == 0){
                String body = String.format(
                        "%d %s %s %s\n%s", messageCount, Instant.now(), message.getBody(), message.getLevel(), "---");
                decoratedMessages[i] = new Message(message.getLevel(), message.getBody());
                i++;
            }else{
                String body = String.format("%d %s %s %s", messageCount, Instant.now(), message.getBody(), message.getLevel());
                decoratedMessages[i] = new Message(message.getLevel(), message.getBody());
                i++;
            }
        }
        return decoratedMessages;
    }

    @Override
    public void isArgsValid(Severity level, String message, String... messages) {
        if (level == null) throw new IllegalArgumentException("Аргумент level не может быть null");
        if (message == null) throw new IllegalArgumentException("Не передан message");
    }
}

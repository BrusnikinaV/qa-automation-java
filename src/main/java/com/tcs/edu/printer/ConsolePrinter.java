package com.tcs.edu.printer;

import com.tcs.edu.decorator.MessageService;
import com.tcs.edu.decorator.enumDecorator.Severity;

/**
 * Класс, предназначенный для описания методов по выводу значений на консоль
 * @author Брусникина Варвара
 */
public class ConsolePrinter {
    /**
     * Вывод на консоль некоторого значения, переданного в аргументе, с последующим переводом
     * курсора консоли на следующую строку;
     * @param message Переменная, которую необходимо вывести на консоль. Например, Hello world!!!;
     * @apiNote Побочных эффектов в этом методе нет
     */
    public static void print(String message) {
        System.out.println(message);
    }
}

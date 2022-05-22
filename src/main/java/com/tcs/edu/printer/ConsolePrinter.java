package com.tcs.edu.printer;

/**
 * Класс, предназначенный для описания методов по выводу значений на консоль
 * @author Брусникина Варвара
 */
public class ConsolePrinter implements Printer {
    /**
     * Вывод на консоль некоторого значения, переданного в аргументе, с последующим переводом
     * курсора консоли на следующую строку;
     * @param message Переменная, которую необходимо вывести на консоль. Например, Hello world!!!;
     * @apiNote Побочных эффектов в этом методе нет
     */
    public void print(String message) {
        System.out.println(message);
    }
}

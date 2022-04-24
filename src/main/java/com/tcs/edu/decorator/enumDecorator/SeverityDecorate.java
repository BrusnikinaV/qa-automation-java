package com.tcs.edu.decorator.enumDecorator;

import com.tcs.edu.enums.Severity;

/**
 * Класс, преобразующий Enum в String
 */
public class SeverityDecorate {
    /**
     * Метод, преобразующий Enum типа Severity в строку
     * @param severity Enum,описывающий важность
     * @return строка, сформированная в зависимости от переданного значения из enum Severity
     */
    public static String enumToString(Severity severity){
        String severityString = null;
        switch (severity){
            case MINOR: severityString = "()"; break;
            case REGULAR: severityString = "(!)"; break;
            case MAJOR: severityString = "(!!!)";
        }
        return severityString;
    }

}

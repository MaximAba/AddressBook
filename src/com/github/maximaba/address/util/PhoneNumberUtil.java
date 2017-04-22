package com.github.maximaba.address.util;

/**
 * Вспомогательная функция для формата номера телефона.
 */
public class PhoneNumberUtil {

    private static StringBuilder sb;

    /**
     * @param number 11 цифр
     * @return телефонный номер в формате *-(***)-***-**-**
     */
    public static String formatTelephoneNumber(String number) {
        sb = new StringBuilder(number);
        sb.insert(1, "-(");
        sb.insert(6, ")-");
        sb.insert(11, "-");
        sb.insert(14, "-");
        return String.valueOf(sb);
    }
}

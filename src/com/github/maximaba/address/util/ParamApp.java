package com.github.maximaba.address.util;

import java.util.prefs.Preferences;

/**
 * Вспомогательный класс настроек.
 */
public class ParamApp {
    public static String language;         //язык

    /**
     * Загрузка настроек.
     */
    public static void load() {
        Preferences prefs = Preferences.userRoot();
        language = prefs.get("key.param.language", "ru");
    }

    /**
     * Сохранение настроек.
     *
     * @param key   ключ параметра
     * @param value значение изменяемое по ключу
     */
    public static void save(String key, String value) {
        Preferences prefs = Preferences.userRoot();
        prefs.put(key, value);
    }
}

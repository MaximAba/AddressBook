package com.github.maximaba.address.util;

import java.util.prefs.Preferences;

/**
 * ¬спомогательный класс обеспечивающий чтение и запись настроек.
 */
public class ParamApp {
    public static String language;         //язык

    /**
     * «агрузка настроек.
     */
    public static void load() {
        Preferences prefs = Preferences.userRoot();
        language = prefs.get("key.param.language", "ru");
    }

    /**
     * —охранение настроек.
     *
     * @param key   ключ параметра
     * @param value записываемое значение
     */
    public static void save(String key, String value) {
        Preferences prefs = Preferences.userRoot();
        prefs.put(key, value);
    }
}

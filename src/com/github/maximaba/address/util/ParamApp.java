package com.github.maximaba.address.util;

import java.util.prefs.Preferences;

/**
 * ��������������� ����� �������������� ������ � ������ ��������.
 */
public class ParamApp {
    public static String language;         //����

    /**
     * �������� ��������.
     */
    public static void load() {
        Preferences prefs = Preferences.userRoot();
        language = prefs.get("key.param.language", "ru");
    }

    /**
     * ���������� ��������.
     *
     * @param key   ���� ���������
     * @param value ������������ ��������
     */
    public static void save(String key, String value) {
        Preferences prefs = Preferences.userRoot();
        prefs.put(key, value);
    }
}

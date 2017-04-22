package com.github.maximaba.address.util;
/**
 * Вспомогательный класс перечисление доступных локализаций c методом возвращающим
 * имя локализации.
 */
public enum LocateUtil {

    RU("Русский"),EN("English");

    LocateUtil(String locate) {
        this.fullName = locate;
    }

    private String fullName;

    public String getName() {
        return fullName;
    }

    public static String formatLang(String locate){
        for (LocateUtil LOC: LocateUtil.values()){
            if (LOC.fullName.equals(locate)) return LOC.name();
        }
        return RU.name();
    }
}

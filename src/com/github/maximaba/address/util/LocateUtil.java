package com.github.maximaba.address.util;

/**
 * Вспомогательный класс перечисление. Хранит возможные локализации.
 */
public enum LocateUtil {

    RU("Русский"), EN("English");

    LocateUtil(String locate) {
        this.fullName = locate;
    }

    private String fullName;

    public String getName() {
        return fullName;
    }

    /**
     * @param locate буквенное сокращенное имя локализации (RU,EN,..)
     * @return Полное имя локализации.
     */
    public static String formatLang(String locate) {
        for (LocateUtil LOC : LocateUtil.values()) {
            if (LOC.fullName.equals(locate)) return LOC.name();
        }
        return RU.name();
    }
}

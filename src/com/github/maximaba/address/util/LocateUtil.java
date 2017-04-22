package com.github.maximaba.address.util;
/**
 * ��������������� ����� ������������ ��������� ����������� c ������� ������������
 * ��� �����������.
 */
public enum LocateUtil {

    RU("�������"),EN("English");

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

package com.github.maximaba.address.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Адаптер (для JAXB) для преобразования между типом LocalDate и строковым
 * представлением даты в стандарте ISO 8601, например как '2012-12-03'.
 *
 */
public class LocalDateAdapter extends XmlAdapter {

    @Override
    public Object unmarshal(Object v) throws Exception {
        return LocalDate.parse((String)v);
    }

    @Override
    public Object marshal(Object v) throws Exception {
        return v.toString();
    }
}
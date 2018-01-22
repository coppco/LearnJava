package com.coppco.controller.converter;

import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * S: source 源
 * T: target 目标
 */
public class GlobalStringToDateConverter implements Converter<String, Date> {
    public Date convert(String source) {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}

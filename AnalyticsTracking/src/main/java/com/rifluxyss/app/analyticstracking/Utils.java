package com.rifluxyss.app.analyticstracking;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String EMPTY = "";

    @SuppressLint("NewApi")
    public static LocalDateTime fromISODateTimeString(String value) {
        String valueDate = value != null ? value.trim() : EMPTY;
        return TextUtils.isEmpty(valueDate) ? LocalDateTime.MIN :  LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @SuppressLint("NewApi")
    public static String toISODateTimeString(LocalDateTime dateTime) {
        return dateTime == null ? EMPTY : dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static String deviceModelCapitalized(String modelName) {
        return modelName.substring(0, 1).toUpperCase() + modelName.substring(1).toLowerCase();
    }

}

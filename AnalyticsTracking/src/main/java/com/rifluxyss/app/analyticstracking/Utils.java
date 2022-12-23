package com.rifluxyss.app.analyticstracking;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String EMPTY = "";

    @SuppressLint("NewApi")
    public static LocalDateTime fromISODateTimeString(String value) {
        value = value != null ? value.trim() : "";
        return TextUtils.isEmpty(value) ? LocalDateTime.MIN :  LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @SuppressLint("NewApi")
    public static String toISODateTimeString(LocalDateTime dateTime) {
        return dateTime == null ? EMPTY : dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static String deviceModelCapitalized(String modelName) {
        return modelName.substring(0, 1).toUpperCase() + modelName.substring(1).toLowerCase();
    }

}

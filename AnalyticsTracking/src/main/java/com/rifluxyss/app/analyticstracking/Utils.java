package com.rifluxyss.app.analyticstracking;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String EMPTY = "";

    @SuppressLint("NewApi")
    public static LocalDateTime fromISODateTimeString(String value)
    {

        value = value != null ? value.trim() : "";

        if (TextUtils.isEmpty(value)) {

            //Default to MIN value
            return LocalDateTime.MIN;
        }
        try
        {
            //DateTimeFormatter is thread safe
            return LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
        catch (Throwable t) {
            return LocalDateTime.MIN;
        }
    }

    @SuppressLint("NewApi")
    public static String toISODateTimeString(LocalDateTime dateTime)
    {
        if (dateTime == null) {
            return EMPTY;
        }
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

}

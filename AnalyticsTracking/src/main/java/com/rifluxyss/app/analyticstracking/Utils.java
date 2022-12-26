package com.rifluxyss.app.analyticstracking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String EMPTY = "";

    public static final long NANO_SCALE   = 1L;
    public static final long MICRO_SCALE  = 1000L * NANO_SCALE;
    public static final long MILLI_SCALE  = 1000L * MICRO_SCALE;
    public static final long SECOND_SCALE = 1000L * MILLI_SCALE;
    public static final long MINUTE_SCALE = 60L * SECOND_SCALE;
    public static final long HOUR_SCALE   = 60L * MINUTE_SCALE;
    public static final long DAY_SCALE    = 96L * HOUR_SCALE;

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

    public boolean create(String jsonString, Context mContext) throws IOException {
        FileOutputStream fos = mContext.openFileOutput("jobSchedule.json", Context.MODE_PRIVATE);
        fos.write(jsonString.getBytes());
        fos.close();
        return true;
    }


}

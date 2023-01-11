package com.rifluxyss.app.analyticstracking.common;

import static android.content.Context.WIFI_SERVICE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@SuppressLint("NewApi")
public class Utils {

    public static String EMPTY = "";
    public static String fileName = "jobSchedule.json";

    public static final long SECOND_MILLIS = 1000;
    public static final long MINUTE_MILLIS = 60 * SECOND_MILLIS;
    public static final long HOUR_MILLIS = 60 * MINUTE_MILLIS;
    public static final long DAY_MILLIS = 24 * HOUR_MILLIS;

    private final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("EEE, d MMM yyyy, HH:mm:ss a");
    private static final DateTimeFormatter legacyEventTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss a");


    public static LocalDateTime fromISODateTimeString(String value) {
        String valueDate = value != null ? value.trim() : EMPTY;
        return TextUtils.isEmpty(valueDate) ? LocalDateTime.MIN : LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }


    public static String toISODateTimeString(LocalDateTime dateTime) {
        return dateTime == null ? EMPTY : dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static String deviceModelCapitalized(String modelName) {
        return modelName.substring(0, 1).toUpperCase() + modelName.substring(1).toLowerCase();
    }


    private String getMillis(long duration) {

        long days = TimeUnit.MILLISECONDS.toDays(duration);
        long hours = TimeUnit.MILLISECONDS.toHours(duration);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);
        return days != 0 ? days + " Days" : hours != 0 ? hours + " Hours" : minutes != 0 ? minutes + " Minutes" : seconds + " Seconds";

    }

    private String expiryDateTime(long duration) {

        long days = TimeUnit.MILLISECONDS.toDays(duration);
        long hours = TimeUnit.MILLISECONDS.toHours(duration);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);

        return days != 0 ? LocalDateTime.now().plusDays(days).format(sdf) : hours != 0 ? LocalDateTime.now().plusHours(hours).format(sdf) :
                minutes != 0 ? LocalDateTime.now().plusMinutes(minutes).format(sdf) : LocalDateTime.now().plusDays(seconds).format(sdf);
    }

    public static String emptyIfNull(String str) {
        if (str != null && !str.equalsIgnoreCase("null")) {
            return str;
        }
        return EMPTY;
    }


}

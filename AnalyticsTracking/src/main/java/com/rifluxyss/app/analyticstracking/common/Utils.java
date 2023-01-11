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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class Utils {

    public static String EMPTY = "";
    public static String fileName = "jobSchedule.json";

    public static final long SECOND_MILLIS = 1000;
    public static final long MINUTE_MILLIS = 60 * SECOND_MILLIS;
    public static final long HOUR_MILLIS = 60 * MINUTE_MILLIS;
    public static final long DAY_MILLIS = 24 * HOUR_MILLIS;


    @SuppressLint("newApi")
    public static LocalDateTime fromISODateTimeString(String value) {
        String valueDate = value != null ? value.trim() : EMPTY;
        return TextUtils.isEmpty(valueDate) ? LocalDateTime.MIN : LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }


    public static String toISODateTimeString(LocalDateTime localDateTime) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            return localDateTime == null ? EMPTY : localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        } else {

            try {

                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy hh:mm:ss a", Locale.US);
                Date dateTime = dateFormat.parse(localDateTime.toString());
                return dateFormat.format(dateTime != null ? dateTime : "").toLowerCase(Locale.ROOT);

            } catch (ParseException exception) {
                exception.printStackTrace();
            }
        }

        return "";
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            DateTimeFormatter sdf = DateTimeFormatter.ofPattern("EEE, d MMM yyyy, HH:mm:ss a");
            return days != 0 ? LocalDateTime.now().plusDays(days).format(sdf) : hours != 0 ? LocalDateTime.now().plusHours(hours).format(sdf) :
                    minutes != 0 ? LocalDateTime.now().plusMinutes(minutes).format(sdf) : LocalDateTime.now().plusDays(seconds).format(sdf);
        }

        return "";
    }

    public static String emptyIfNull(String str) {
        if (str != null && !str.equalsIgnoreCase("null")) {
            return str;
        }
        return EMPTY;
    }


}

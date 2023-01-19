package com.rifluxyss.app.analyticstracking.common;


import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


/**
 * Initialize the Utils Class
 */
public class Utils {

    /**
     * Initialization of String variable
     */
    public static String EMPTY = "";

    /**
     * Initialization of long variable SECOND_MILLIS
     */
    public static final long SECOND_MILLIS = 1000;

    /**
     * Initialization of long variable of MINUTE_MILLIS
     */
    public static final long MINUTE_MILLIS = 60 * SECOND_MILLIS;

    /**
     * Initialization of long variable of HOUR_MILLIS
     */
    public static final long HOUR_MILLIS = 60 * MINUTE_MILLIS;

    /**
     * Initialization of long variable of DAY_MILLIS
     */
    public static final long DAY_MILLIS = 24 * HOUR_MILLIS;


    /**
     * @param value of Current Date Time Value
     * @return LocalDateTime value
     */
    @SuppressLint("newApi")
    public static LocalDateTime fromISODateTimeString(String value) {
        String valueDate = value != null ? value.trim() : EMPTY;
        return TextUtils.isEmpty(valueDate) ? LocalDateTime.MIN : LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }


    /**
     * @param localDateTime of value
     * @return the LocalDateTime of String Value
     */
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

    /**
     * @param modelName of Device Model
     * @return First letter of the String Capitalized
     */
    @NonNull
    public static String deviceModelCapitalized(String modelName) {
        return modelName.substring(0, 1).toUpperCase() + modelName.substring(1).toLowerCase();
    }


    /**
     * @param duration of Long value
     * @return the String value of duration of millis
     */
    @NonNull
    public String getMillis(long duration) {

        long days = TimeUnit.MILLISECONDS.toDays(duration);
        long hours = TimeUnit.MILLISECONDS.toHours(duration);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);
        return days != 0 ? days + " Days" : hours != 0 ? hours + " Hours" : minutes != 0 ? minutes + " Minutes" : seconds + " Seconds";

    }

    /**
     * @param duration of Long value
     * @return the String value of Expire DateTime
     */
    @NonNull
    public String expiryDateTime(long duration) {

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

    /**
     * @param value of String
     * @return check the condition to return the value
     */
    public static String emptyIfNull(String value) {
        return value != null ? value : EMPTY;
    }


}

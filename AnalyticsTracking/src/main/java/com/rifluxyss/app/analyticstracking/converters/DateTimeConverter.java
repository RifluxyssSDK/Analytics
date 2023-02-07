package com.rifluxyss.app.analyticstracking.converters;

import androidx.room.TypeConverter;

import com.rifluxyss.app.analyticstracking.common.Utils;

import java.time.LocalDateTime;

/**
 * The type Date time converter.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class DateTimeConverter {

    /**
     * From date time string local date time.
     *
     * @param value to get the Current DateTime
     * @return the LocalDateTime value
     */
    @TypeConverter
    public static LocalDateTime fromDateTimeString(String value) {
        return new Utils().fromISODateTimeString(value);
    }

    /**
     * To date time string string.
     *
     * @param value to get the Current DateTime
     * @return the LocalDateTime using return the String of DateTime
     */
    @TypeConverter
    public static String toDateTimeString(LocalDateTime value) {
        return new Utils().toISODateTimeString(value);
    }
}

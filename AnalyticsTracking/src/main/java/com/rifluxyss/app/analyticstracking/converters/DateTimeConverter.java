package com.rifluxyss.app.analyticstracking.converters;

import androidx.room.TypeConverter;

import com.rifluxyss.app.analyticstracking.common.Utils;

import java.text.ParseException;
import java.time.LocalDateTime;

public class DateTimeConverter {

    /**
     * @param value to get the Current DateTime
     * @return the LocalDateTime value
     */
    @TypeConverter
    public static LocalDateTime fromDateTimeString(String value) {
        return Utils.fromISODateTimeString(value);
    }

    /**
     * @param value to get the Current DateTime
     * @return the LocalDateTime using return the String of DateTime
     */
    @TypeConverter
    public static String toDateTimeString(LocalDateTime value) {
        return Utils.toISODateTimeString(value);
    }
}

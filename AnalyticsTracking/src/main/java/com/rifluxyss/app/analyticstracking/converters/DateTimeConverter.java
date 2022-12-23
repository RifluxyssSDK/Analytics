package com.rifluxyss.app.analyticstracking.converters;

import androidx.room.TypeConverter;

import com.rifluxyss.app.analyticstracking.Utils;
import java.time.LocalDateTime;

public class DateTimeConverter
{

    @TypeConverter
    public static LocalDateTime fromDateTimeString(String value) {
        return Utils.fromISODateTimeString(value);
    }

    @TypeConverter
    public static String toDateTimeString(LocalDateTime value) {
        return Utils.toISODateTimeString(value);
    }
}

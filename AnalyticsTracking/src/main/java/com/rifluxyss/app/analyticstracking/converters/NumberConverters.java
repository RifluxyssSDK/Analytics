package com.rifluxyss.app.analyticstracking.converters;

import androidx.room.TypeConverter;


public class NumberConverters {

    @TypeConverter
    public static int fromNumberValue(Number value) {

        if (value instanceof Double) {

            return (int) value.doubleValue();

        } else if (value instanceof Long) {

            return (int) value.longValue();

        } else if (value instanceof Float) {

            return (int) value.floatValue();

        } else if (value instanceof  Byte) {

            return value.byteValue();

        } else if (value instanceof Short) {

            return value.shortValue();

        } else {

            return value.intValue();
        }

    }

}

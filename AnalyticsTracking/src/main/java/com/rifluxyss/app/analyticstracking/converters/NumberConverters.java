package com.rifluxyss.app.analyticstracking.converters;

import androidx.room.TypeConverter;


public class NumberConverters {

    @TypeConverter
    public static int fromNumberValueInt(Number value) {
        return value.intValue();
    }

    @TypeConverter
    public static double fromNumberValueDouble(Number value) {
        return value.doubleValue();
    }

    @TypeConverter
    public static long fromNumberValueLong(Number value) {
        return value.longValue();
    }

    @TypeConverter
    public static float fromNumberValueFloat(Number value) {
        return value.floatValue();
    }

    @TypeConverter
    public static byte fromNumberValueByte(Number value) {
        return value.byteValue();
    }

    @TypeConverter
    public static short fromNumberValueShort(Number value) {
        return value.shortValue();
    }

}

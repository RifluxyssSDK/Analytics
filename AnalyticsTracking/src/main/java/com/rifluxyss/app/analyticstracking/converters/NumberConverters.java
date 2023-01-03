package com.rifluxyss.app.analyticstracking.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;


public class NumberConverters {

    @TypeConverter
    public static String fromNumberValue(Number value) {
        return new Gson().toJson(value);
    }

    @TypeConverter
    public static Number fromNumberString(String value) {
        return new Gson().fromJson(value,Number.class);
    }

}

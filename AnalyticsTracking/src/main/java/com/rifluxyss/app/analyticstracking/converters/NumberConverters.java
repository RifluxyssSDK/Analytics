package com.rifluxyss.app.analyticstracking.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;


public class NumberConverters {

    /**
     * @param value of the Number
     * @return the Number Based on the String value
     */
    @TypeConverter
    public static String fromNumberValue(Number value) {
        return new Gson().toJson(value);
    }

    /**
     * @param value of the String
     * @return Gson().fromJson() using based on the Number value return
     */
    @TypeConverter
    public static Number fromNumberString(String value) {
        return new Gson().fromJson(value, Number.class);
    }

}

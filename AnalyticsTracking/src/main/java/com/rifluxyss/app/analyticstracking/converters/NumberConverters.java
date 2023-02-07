package com.rifluxyss.app.analyticstracking.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;


/**
 * The type Number converters.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class NumberConverters {

    /**
     * From number value string.
     *
     * @param value of the Number
     * @return the Number Based on the String value
     */
    @TypeConverter
    public static String fromNumberValue(Number value) {
        return new Gson().toJson(value);
    }

    /**
     * From number string number.
     *
     * @param value of the String
     * @return Gson().fromJson() using based on the Number value return
     */
    @TypeConverter
    public static Number fromNumberString(String value) {
        return new Gson().fromJson(value, Number.class);
    }

}

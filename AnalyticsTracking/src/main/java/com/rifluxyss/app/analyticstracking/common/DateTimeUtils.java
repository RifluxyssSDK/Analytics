package com.rifluxyss.app.analyticstracking.common;

import android.annotation.SuppressLint;
import android.os.Build;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {

    /**
     * @return LocalDateTime
     * Get the current Date Time of using LocalDateTime.now()
     * getLocalDateTime()
     */
    @SuppressLint("NewApi")
    public LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * The Calendar.getInstance() method in Calendar class is used to get a calendar using the current Day of week and locale of the system.
     *
     * @return Week of the Day integer value
     * getWeekOfDay() to get a calendar using the current Day of week integer value
     */
    public Integer getWeekOfDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * @param localDateTime of LocalDateTime
     * @return String of DateTime
     * @throws ParseException
     */
    public String getDateTime(LocalDateTime localDateTime) throws ParseException {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            DateTimeFormatter legacyEventTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss a");
            return localDateTime.format(legacyEventTimeFormatter).toLowerCase(Locale.ROOT);

        } else {

            // SimpleDateFormat to get displaying date in MM/dd/yy hh:mm:ss a format
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy hh:mm:ss a", Locale.US);
            //parse() method of a Date class
            Date dateTime = dateFormat.parse(localDateTime.toString());
            // Date  used to get an instance of LocalDateTime from a string such as '01-18-2023 05:30:22 am' passed as parameter.
            return dateFormat.format(dateTime != null ? dateTime : "").toLowerCase(Locale.ROOT);

        }
    }
}

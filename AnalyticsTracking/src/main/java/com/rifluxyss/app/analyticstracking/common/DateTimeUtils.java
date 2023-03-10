package com.rifluxyss.app.analyticstracking.common;

import android.annotation.SuppressLint;
import android.os.Build;

import com.rifluxyss.app.analyticstracking.AppManagerSingleton;
import com.rifluxyss.app.analyticstracking.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * The type Date time utils.
 */
public class DateTimeUtils extends AppManagerSingleton {

    /**
     * The Date time format.
     */
    protected String dateTimeFormat = getInstance().getContext().getString(R.string.str_datetimeFormat);

    /**
     * Gets local date time.
     *
     * @return LocalDateTime  Get the current Date Time of using LocalDateTime.now() getLocalDateTime()
     */
    @SuppressLint("NewApi")
    public LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * The Calendar.getInstance() method in Calendar class is used to get a calendar using the current Day of week and locale of the system.
     *
     * @return Week of the Day integer value getDayOfWeek() to get a calendar using the current Day of week integer value
     */
    public Integer getDayOfWeek() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            return LocalDateTime.now().getDayOfWeek().getValue() + 1;

        } else {
            Calendar calendar = Calendar.getInstance();
            return calendar.get(Calendar.DAY_OF_WEEK);
        }
    }

    /**
     * Gets date time.
     *
     * @param localDateTime of LocalDateTime
     * @return String of DateTime
     * @throws ParseException the parse exception
     */
    public String getDateTime(LocalDateTime localDateTime) throws ParseException {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            DateTimeFormatter legacyEventTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);
            return localDateTime.format(legacyEventTimeFormatter).toLowerCase(Locale.ROOT);

        } else {

            // SimpleDateFormat to get displaying date in MM/dd/yy hh:mm:ss a format
            SimpleDateFormat dateFormat = new SimpleDateFormat(dateTimeFormat, Locale.US);
            //parse() method of a Date class
            Date dateTime = dateFormat.parse(localDateTime.toString());
            // Date  used to get an instance of LocalDateTime from a string such as '01-18-2023 05:30:22 am' passed as parameter.
            return dateFormat.format(dateTime != null ? dateTime : getInstance().getContext().getString(R.string.empty_string)).toLowerCase(Locale.ROOT);

        }
    }
}

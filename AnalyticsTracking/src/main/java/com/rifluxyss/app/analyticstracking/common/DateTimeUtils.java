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

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy hh:mm:ss a", Locale.US);

    @SuppressLint("NewApi")
    public LocalDateTime getLocalDateTime() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            return LocalDateTime.now();

        } else {

            Calendar calendar = Calendar.getInstance();
            String dateTime = dateFormat.format(calendar.getTime()).toLowerCase(Locale.ROOT);
            return LocalDateTime.parse(dateTime);

        }
    }

    public Integer getWeekOfDay() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            return LocalDateTime.now().getDayOfWeek().getValue();

        } else {

            Calendar calendar = Calendar.getInstance();
            return calendar.get(Calendar.DAY_OF_WEEK);

        }
    }

    public String getDateTime(LocalDateTime localDateTime) throws ParseException {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            DateTimeFormatter legacyEventTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss a");
            return localDateTime.format(legacyEventTimeFormatter).toLowerCase(Locale.ROOT);

        } else {

            Date dateTime = dateFormat.parse(localDateTime.toString());
            return dateFormat.format(dateTime != null ? dateTime : "").toLowerCase(Locale.ROOT);

        }
    }
}

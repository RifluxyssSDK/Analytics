package android.analytics;

import android.annotation.SuppressLint;
import android.text.format.DateFormat;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 * The type Util.
 */
public class Util {

    /**
     * Gets date.
     *
     * @param addExtraDays the add extra days
     * @return the date
     */
    public static String getDate(int addExtraDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, addExtraDays);
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.getDefault());
        return simpleDateFormat.format(date);
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public static String getTime() {
        return (String) DateFormat.format("HH:mm aaa",Calendar.getInstance().getTime());
    }

    /**
     * Date compare int.
     *
     * @param currentDate the current date
     * @param expiryDate  the expiry date
     * @return the int
     */
    public static int dateCompare(String currentDate, String expiryDate) {

        try {

            @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

            Date startDate = simpleDateFormat.parse(currentDate);
            Date endDate = simpleDateFormat.parse(expiryDate);

            long different = Objects.requireNonNull(endDate).getTime() - Objects.requireNonNull(startDate).getTime();

            long secondsInMilli = 1000;
            long minutesInMilli = secondsInMilli * 60;
            long hoursInMilli = minutesInMilli * 60;
            long daysInMilli = hoursInMilli * 24;

            long elapsedDays = different / daysInMilli;
            different = different % daysInMilli;

            long elapsedHours = different / hoursInMilli;
            different = different % hoursInMilli;

            long elapsedMinutes = different / minutesInMilli;
            different = different % minutesInMilli;

            long elapsedSeconds = different / secondsInMilli;

            Log.i("Analytics days ", elapsedDays + "");
            Log.i("Analytics hours ", elapsedHours + "");
            Log.i("Analytics minutes ", elapsedMinutes + "");
            Log.i("Analytics seconds ", elapsedSeconds + "");

            return (int) elapsedDays;

        } catch (ParseException error) {
            error.printStackTrace();
            return 1;
        }
    }

}

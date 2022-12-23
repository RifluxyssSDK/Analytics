package android.analytics;

import android.text.format.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Util {

    public static String getDate(int addExtraDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, addExtraDays);
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        return simpleDateFormat.format(date);
    }

    public static String getTime() {
        return (String) DateFormat.format("HH:mm aaa",Calendar.getInstance().getTime());
    }
}

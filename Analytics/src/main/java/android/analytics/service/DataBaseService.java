package android.analytics.service;

import android.analytics.Util;
import android.analytics.kernel.Instance;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

public class DataBaseService {

    public DataBaseService(Context context) {

        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.HOUR_OF_DAY, 4);
//        mCalendar.set(Calendar.MINUTE, 47);

        Intent intent = new Intent(context, BackgroundService.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 100, intent, 0);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,mCalendar.getTimeInMillis(),(15 * 60 * 1000),pendingIntent);

        Log.i("Analytics", "Init Service...");
        Log.i("Analytics", "Init Size Of DataBase " + Instance.getDao().getAllScheme().size());
    }
}

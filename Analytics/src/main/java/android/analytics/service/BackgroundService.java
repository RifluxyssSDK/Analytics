package android.analytics.service;

import android.analytics.dataBase.Dao;
import android.analytics.dataBase.Database;
import android.analytics.dataBase.Schema;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@SuppressLint({"UnspecifiedImmutableFlag"})
public class BackgroundService extends BroadcastReceiver {

    public BackgroundService(Context context) {

        Calendar mCalender = Calendar.getInstance();
        mCalender.set(Calendar.HOUR_OF_DAY, 23);
        mCalender.setTimeInMillis(System.currentTimeMillis());

        ((android.app.AlarmManager) context.getSystemService(Context.ALARM_SERVICE))
                .setInexactRepeating(
                        android.app.AlarmManager.RTC_WAKEUP,
                        mCalender.getTimeInMillis(),
                        android.app.AlarmManager.INTERVAL_DAY,
                        PendingIntent.getBroadcast(
                                context,
                                (101),
                                new Intent(context, BackgroundService.class),
                                (0)
                        )
                );
        Log.i("Analytics", "Init Background Service...");
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Dao dao = Database.getInstance(context).dao();

        Log.i("Analytics", "Size Of DataBase Before Deleting: " + dao.getAllScheme().size());

        for (Schema schema : dao.getAllScheme()) {
            if (schema.getExpiryDate().equalsIgnoreCase(new SimpleDateFormat(
                    ("dd-MM-yyyy"),
                    Locale.getDefault()).format(Calendar.getInstance().getTime())
            )) {
                dao.delete(schema);
            }
        }

        Log.i("Analytics", "Size Of DataBase After Deleting: " + dao.getAllScheme().size());
    }
}

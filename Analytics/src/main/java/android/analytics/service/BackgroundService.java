package android.analytics.service;

import android.analytics.dataBase.Dao;
import android.analytics.dataBase.Database;
import android.analytics.dataBase.Schema;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BackgroundService extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Dao dao = Database.getInstance(context).dao();

        Log.i("Analytics", "Size Of DataBase Before Deleting: " + dao.getAllScheme().size());

        for (Schema schema : dao.getAllScheme()) {
            if (schema.getExpiryDate().equalsIgnoreCase(new SimpleDateFormat(
                    ("dd-MM-yyyy"),
                    Locale.getDefault()).format(Calendar.getInstance().getTime())
            ) || true) {
                dao.delete(schema);
            }
        }

        Log.i("Analytics", "Size Of DataBase After Deleting: " + dao.getAllScheme().size());
    }
}

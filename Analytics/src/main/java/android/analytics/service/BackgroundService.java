package android.analytics.service;

import android.analytics.Kernel.Instance;
import android.analytics.dataBase.Schema;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * The type Background service.
 */
public class BackgroundService extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Instance instance = Instance.getInstance();
        instance.initDB(context);

        Log.i("Analytics", "Size Of DataBase Before Deleting: " + instance.getDao().getAllScheme().size());

        for (Schema schema : instance.getDao().getAllScheme()) {
            if (schema.getExpiryDate().equalsIgnoreCase(new SimpleDateFormat(
                    ("dd-MM-yyyy"),
                    Locale.getDefault()).format(Calendar.getInstance().getTime())
            ) || true ) {
                instance.getDao().delete(schema);
            }
        }

        Log.i("Analytics", "Size Of DataBase After Deleting: " + instance.getDao().getAllScheme().size());
    }
}

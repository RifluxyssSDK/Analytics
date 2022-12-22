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

public class BackgroundService extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("STATUS", "Deleting Expire Details On Database");

        Instance instance = Instance.getInstance();
        instance.initDB(context);

        Log.e("STATUS", "SIZE : " + instance.getDao().getAllScheme().size());

        for (Schema schema : instance.getDao().getAllScheme()) {
            if (schema.getExpiryDate().equalsIgnoreCase(
                    new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Calendar.getInstance().getTime()))) {
                instance.getDao().delete(schema);
            }
        }

        Log.e("STATUS", "SIZE : " + instance.getDao().getAllScheme().size());
    }
}

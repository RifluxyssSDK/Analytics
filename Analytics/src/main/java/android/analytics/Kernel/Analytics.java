package android.analytics.Kernel;

import android.analytics.dataBase.Schema;
import android.analytics.service.BackgroundService;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The type Analytics.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Analytics extends Instance {

    /**
     * Init.
     *
     * @param context           the context
     * @param logExpireDayCount the log expire day count
     */
    public static void init(Context context, int logExpireDayCount) {
        getInstance().initDB(context);
        getInstance().initService();
        getInstance().setLogExpireDayCount(logExpireDayCount);
    }

    /**
     * Insert.
     *
     * @param <T>   the type parameter
     * @param klass the klass
     */
    public static <T> void insert(T klass) {
        getInstance().getDao().insert(new Schema(klass.getClass().getCanonicalName(), new Gson().toJson(klass)));
    }

    /**
     * Get list.
     *
     * @param <T>   the type parameter
     * @param klass the klass
     * @return the list
     */
    public static <T> List<T> get(Class<T> klass) {
        ArrayList<T> tArrayList = new ArrayList<>();
        for (Schema schema : getInstance().getDao().getAllScheme()) {
            if (schema.getKey().equals(klass.getCanonicalName())) {
                tArrayList.add(new Gson().fromJson(schema.getData(), klass));
            }
        }
        return tArrayList;
    }
}

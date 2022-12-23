package android.analytics.kernel;

import android.analytics.dataBase.Database;
import android.analytics.dataBase.Schema;
import android.analytics.service.DataBaseService;
import android.content.Context;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Analytics {

    public static void init(Context context, int logExpireDayCount) {

        // Store the given data's as static variable
        Instance.setLogExpireDayCount(logExpireDayCount);

        // Initiating Database
        Instance.setDao(Database.getInstance(context).dao());

        // Initiating BackgroundService
        new DataBaseService(context);
    }

    public static void logInfo(Schema schema) {
        Instance.getDao().insert(schema);
    }
}

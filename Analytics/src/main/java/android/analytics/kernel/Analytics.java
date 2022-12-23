package android.analytics.kernel;

import android.analytics.dataBase.Database;
import android.analytics.dataBase.Schema;
import android.analytics.optimizer.LogFactory;
import android.content.Context;

import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Analytics {

    public static void init(Context context, int logExpireDayCount) {

        // Store the given data's as static variable
        Instance.setLogExpireDayCount(logExpireDayCount);

        // Initiating database
        Instance.setDao(Database.getInstance(context).dao());

        // Delete expired logs on local database
        LogFactory.deleteExpiryLogs();
    }

    public static void insertLog(Schema schema) {
        if (Instance.getDao() != null) {
            Instance.getDao().insert(schema);
        } else {
            throw new NullPointerException("You have been must call 'init' method on Analytics or Null Context");
        }
    }

    public static List<Schema> getLogs() {
        return Instance.getDao().getAllScheme();
    }
}

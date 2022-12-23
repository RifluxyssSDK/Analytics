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

        // Initiating Database
        Instance.setDao(Database.getInstance(context).dao());

        LogFactory.deleteExpiryLogs();
    }

    public static void insertLog(Schema schema) {
        Instance.getDao().insert(schema);
    }

    public static List<Schema> getLogs() {
        return Instance.getDao().getAllScheme();
    }
}

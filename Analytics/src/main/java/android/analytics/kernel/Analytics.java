package android.analytics.kernel;

import android.analytics.dataBase.Database;
import android.analytics.dataBase.Schema;
import android.analytics.optimizer.LogFactory;
import android.content.Context;

import java.util.List;

/**
 * The type Analytics.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Analytics {

    /**
     * Init.
     *
     * @param context           the context
     * @param logExpireDayCount the log expire day count
     */
    public static void init(Context context, int logExpireDayCount) {

        // Store the given data's as static variable
        Instance.setContext(context);
        Instance.setLogExpireDayCount(logExpireDayCount);

        // Initiating database
        Instance.setDao(Database.getInstance().dao());

        // Delete expired logs on local database
        LogFactory.deleteExpiryLogs();
    }

    /**
     * Insert log.
     *
     * @param schema the schema
     */
    public static void insertLog(Schema schema) {
        if (Instance.getContext() != null) {
            Instance.getDao().insert(schema);
        } else {
            throw new NullPointerException("You have been must call 'init' method on Analytics or Null Context");
        }
    }

    /**
     * Gets logs.
     *
     * @return the logs
     */
    public static List<Schema> getLogs() {
        return Instance.getDao().getAllScheme();
    }
}

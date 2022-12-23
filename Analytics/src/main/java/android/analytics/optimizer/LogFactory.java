package android.analytics.optimizer;

import android.analytics.Util;
import android.analytics.dataBase.Dao;
import android.analytics.dataBase.Schema;
import android.analytics.kernel.Instance;

/**
 * The type Log factory.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class LogFactory {

    /**
     * Delete expiry logs.
     */
    public static void deleteExpiryLogs() {

        new Thread(() -> {

            Dao dao = Instance.getDao();
            String currentDate = Util.getDate(0);

            for (Schema schema : dao.getAllScheme()) {
                if (Util.dateCompare(currentDate, schema.getExpiryDate()) <= 0) {
                    dao.delete(schema);
                }
            }

        }).start();
    }
}

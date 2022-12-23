package android.analytics.optimizer;

import android.analytics.Util;
import android.analytics.dataBase.Dao;
import android.analytics.dataBase.Schema;
import android.analytics.kernel.Instance;

public class LogFactory {

    public static void deleteExpiryLogs() {

        Dao dao = Instance.getDao();
        String currentDate = Util.getDate(0);

        for (Schema schema : dao.getAllScheme()) {
            if (Util.dateCompare(currentDate, schema.getExpiryDate()) <= 0) {
                dao.delete(schema);
            }
        }
    }
}

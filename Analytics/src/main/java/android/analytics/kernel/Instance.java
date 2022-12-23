package android.analytics.kernel;

import android.analytics.dataBase.Dao;

public class Instance {

    private static Dao dao;

    private static int logExpireDayCount;

    public static Dao getDao() {
        return dao;
    }

    public static void setDao(Dao dao) {
        Instance.dao = dao;
    }

    public static int getLogExpireDayCount() {
        return logExpireDayCount;
    }

    public static void setLogExpireDayCount(int logExpireDayCount) {
        Instance.logExpireDayCount = logExpireDayCount;
    }
}

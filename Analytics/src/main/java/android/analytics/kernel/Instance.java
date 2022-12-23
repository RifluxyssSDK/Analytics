package android.analytics.kernel;

import android.analytics.dataBase.Dao;
import android.annotation.SuppressLint;
import android.content.Context;

@SuppressLint("StaticFieldLeak")
public class Instance {

    private static Dao dao;

    private static Context context;

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

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        Instance.context = context;
    }
}

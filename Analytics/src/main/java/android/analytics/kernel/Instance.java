package android.analytics.kernel;

import android.analytics.dataBase.Dao;
import android.annotation.SuppressLint;
import android.content.Context;

/**
 * The type Instance.
 */
@SuppressLint("StaticFieldLeak")
public class Instance {

    private static Dao dao;

    private static Context context;

    private static int logExpireDayCount;

    /**
     * Gets dao.
     *
     * @return the dao
     */
    public static Dao getDao() {
        return dao;
    }

    /**
     * Sets dao.
     *
     * @param dao the dao
     */
    public static void setDao(Dao dao) {
        Instance.dao = dao;
    }

    /**
     * Gets log expire day count.
     *
     * @return the log expire day count
     */
    public static int getLogExpireDayCount() {
        return logExpireDayCount;
    }

    /**
     * Sets log expire day count.
     *
     * @param logExpireDayCount the log expire day count
     */
    public static void setLogExpireDayCount(int logExpireDayCount) {
        Instance.logExpireDayCount = logExpireDayCount;
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    public static Context getContext() {
        return context;
    }

    /**
     * Sets context.
     *
     * @param context the context
     */
    public static void setContext(Context context) {
        Instance.context = context;
    }
}

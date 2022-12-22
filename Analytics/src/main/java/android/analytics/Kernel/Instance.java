package android.analytics.Kernel;

import android.analytics.dataBase.Dao;
import android.analytics.dataBase.Database;
import android.content.Context;

/**
 * The type Instance.
 */
public class Instance {

    private Dao dao;

    private Context context;

    private int logExpireDayCount;

    private static Instance instance;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }
        return instance;
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    public Context getContext() {
        return context;
    }

    /**
     * Sets context.
     *
     * @param context the context
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * Gets dao.
     *
     * @return the dao
     */
    public Dao getDao() {
        return dao;
    }

    /**
     * Sets dao.
     *
     * @param dao the dao
     */
    public void setDao(Dao dao) {
        this.dao = dao;
    }

    /**
     * Gets log expire day count.
     *
     * @return the log expire day count
     */
    public int getLogExpireDayCount() {
        return logExpireDayCount;
    }

    /**
     * Sets log expire day count.
     *
     * @param logExpireDayCount the log expire day count
     */
    public void setLogExpireDayCount(int logExpireDayCount) {
        this.logExpireDayCount = logExpireDayCount;
    }

    /**
     * Init db.
     *
     * @param context the context
     */
    public void initDB(Context context) {
        setContext(context);
        setDao(Database.getInstance().dao());
    }
}

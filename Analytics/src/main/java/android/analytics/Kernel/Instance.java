package android.analytics.Kernel;

import android.analytics.dataBase.Dao;
import android.analytics.dataBase.Database;
import android.analytics.service.BackgroundService;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

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

    /**
     * Init service. Everyday 11:00 PM Called This Service By Default
     */
    protected void initService() {

        Log.i("Analytics", "Init Background Service...");

        AlarmManager alarmManager = (AlarmManager) getInstance().getContext().getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 23);

        alarmManager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,
                PendingIntent.getBroadcast(
                        getInstance().getContext(),
                        (101),
                        new Intent(getInstance().getContext(), BackgroundService.class),
                        (0))
        );
    }
}

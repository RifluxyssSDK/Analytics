package android.analytics.Kernel;

import android.analytics.dataBase.Dao;
import android.analytics.dataBase.Database;
import android.analytics.dataBase.Schema;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Instance {

    private Dao dao;

    private Context context;

    private int logExpireDayCount;

    private static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }
        return instance;
    }

    public static void setInstance(Instance instance) {
        Instance.instance = instance;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public int getLogExpireDayCount() {
        return logExpireDayCount;
    }

    public void setLogExpireDayCount(int logExpireDayCount) {
        this.logExpireDayCount = logExpireDayCount;
    }

    public void initDB(Context context) {
        setContext(context);
        setDao(Database.getInstance().dao());
    }
}

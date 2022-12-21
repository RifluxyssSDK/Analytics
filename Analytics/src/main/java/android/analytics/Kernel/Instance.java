package android.analytics.Kernel;

import android.analytics.dataBase.Dao;
import android.analytics.dataBase.Database;
import android.content.Context;

public class Instance {

    private Dao dao;

    private Context context;

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

    protected <T> void initDB(Context context) {
        setContext(context);
        setDao(Database.getInstance().dao());
    }

}

package android.analytics.Kernel;

import android.analytics.dataBase.Schema;
import android.content.Context;

import java.util.List;

public class Analytics extends Instance {

    public static void init(Context context, int Duration) {
        getInstance().initDB(context);
    }

    public static void Log(Schema schema) {
        getInstance().getDao().insert(schema);
    }

    public static List<Schema> getLog() {
        return getInstance().getDao().getAllScheme();
    }

    public static void duration(int Duration) {
    }
}

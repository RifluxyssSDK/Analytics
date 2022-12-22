package android.analytics.Kernel;

import android.analytics.dataBase.Schema;
import android.content.Context;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Analytics extends Instance {

    public static void init(Context context) {
        getInstance().initDB(context);
    }

    public static <T> void insert(T klass) {
        getInstance().getDao().insert(new Schema(klass.getClass().getCanonicalName(), new Gson().toJson(klass)));
    }

    public static <T> List<T> get(Class<T> klass) {
        ArrayList<T> tArrayList = new ArrayList<>();
        for (Schema schema : getInstance().getDao().getAllScheme()) {
            if (schema.getKey().equals(klass.getCanonicalName())) {
                tArrayList.add(new Gson().fromJson(schema.getData(), klass));
            }
        }
        return tArrayList;
    }

    public static void terminate() {
        setInstance(null);
    }
}

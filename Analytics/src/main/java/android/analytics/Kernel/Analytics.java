package android.analytics.Kernel;

import android.analytics.dataBase.Schema;
import android.content.Context;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Analytics extends Instance {

    public static void init(Context context,int logExpireDayCount) {
        getInstance().initDB(context);
        getInstance().setLogExpireDayCount(logExpireDayCount);
        deleteExpiryData();
    }

    private static void deleteExpiryData() {
        for (Schema schema : getInstance().getDao().getAllScheme()) {
            if (schema.getExpiryDate().equalsIgnoreCase(
                    new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Calendar.getInstance().getTime()))
            ) {
                getInstance().getDao().delete(schema);
            }
        }
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
}

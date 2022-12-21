package android.analytics.kernal;

import android.analytics.Utils;
import android.content.Context;

public class Analytics extends Utils {
    public static void init(Context context) {
        getUtils().setContext(context);
    }
}

package android.analytics;

import android.analytics.kernal.Analytics;
import android.content.Context;

public class Utils {

    private Context context;

    private Analytics analytics;

    private static Utils utils;

    public Context getContext() {
        return getUtils().context;
    }

    public void setContext(Context context) {
        getUtils().context = context;
    }

    public static Utils getUtils() {
        if (utils == null) {
            utils = new Utils();
        }
        return utils;
    }

    public static void setUtils(Utils instance) {
        Utils.utils = instance;
    }

    public Analytics getAnalytics() {
        return analytics;
    }

    public void setAnalytics(Analytics analytics) {
        this.analytics = analytics;
    }
}

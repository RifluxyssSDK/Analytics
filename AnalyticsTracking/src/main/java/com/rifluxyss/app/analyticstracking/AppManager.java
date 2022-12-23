package com.rifluxyss.app.analyticstracking;

import android.annotation.SuppressLint;
import android.content.Context;

public class AppManager {

    private Lazy<AnalyticsDatabase> localDatabaseLazy;

    private static AppManager mAppManagerInstance;

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static AppManager getInstance() {

        if (mAppManagerInstance == null) {

            mAppManagerInstance = new AppManager();

        }

        return mAppManagerInstance;
    }

    public void initialize(Context context) {

        this.context = context;
        localDatabaseLazy = Lazy.create(() -> AnalyticsDatabase.build(context));
    }


    public static Context getContext() {
        return context;
    }

    public static AnalyticsDatabase localDatabase() {
        return getInstance().localDatabaseLazy.get();
    }


}

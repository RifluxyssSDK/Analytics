package com.rifluxyss.app.analyticstracking;

import android.annotation.SuppressLint;
import android.content.Context;

@SuppressLint("StaticFieldLeak")
public class AppManagerSingleton {

    private Lazy<AnalyticsDatabase> localDatabaseLazy;

    protected static AppManagerSingleton mAppManagerSingletonInstance;

    protected Context context;

    public static AppManagerSingleton getInstance() {

        if (mAppManagerSingletonInstance == null) {

            mAppManagerSingletonInstance = getSync();

        }

        return mAppManagerSingletonInstance;
    }

    private static synchronized AppManagerSingleton getSync() {
        if (mAppManagerSingletonInstance == null) mAppManagerSingletonInstance = new AppManagerSingleton();
        return mAppManagerSingletonInstance;
    }

    public void initialize(Context context) {
        this.context = context;
        localDatabaseLazy = Lazy.create(() -> AnalyticsDatabase.build(context));
    }

    public Context getContext() {
        return context;
    }

    public AnalyticsDatabase localDatabase() {
        return getInstance().localDatabaseLazy.get();
    }


}

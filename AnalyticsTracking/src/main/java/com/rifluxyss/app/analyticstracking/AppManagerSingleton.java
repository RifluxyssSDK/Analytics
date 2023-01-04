package com.rifluxyss.app.analyticstracking;

import android.annotation.SuppressLint;
import android.content.Context;

@SuppressLint("StaticFieldLeak")
public class AppManagerSingleton {

    protected static AppManagerSingleton mAppManagerSingletonInstance;

    protected Context context;

    protected AnalyticsDatabase mAnalyticsDatabase;

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
        mAnalyticsDatabase = AnalyticsDatabase.build(context);
    }

    public Context getContext() {
        return context;
    }

    public AnalyticsDatabase localDatabase() {
        return getInstance().mAnalyticsDatabase;
    }

}

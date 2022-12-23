package com.rifluxyss.app.analyticstracking;

import android.content.Context;

public class AppManager {

    private Lazy<AnalyticsDatabase> localDatabaseLazy;

    protected static AppManager mAppManagerInstance;

    public static AppManager getInstance() {

        if (mAppManagerInstance == null) {

            mAppManagerInstance = new AppManager();

        }

        return mAppManagerInstance;
    }

    public void initialize(Context context) {
        localDatabaseLazy = Lazy.create(() -> AnalyticsDatabase.build(context));
    }


    public static AnalyticsDatabase localDatabase() {
        return getInstance().localDatabaseLazy.get();
    }


}

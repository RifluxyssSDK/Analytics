package com.rifluxyss.app.analyticstracker;

import android.app.Application;

import com.rifluxyss.app.analyticstracking.AppManager;
import com.rifluxyss.app.analyticstracking.log.Analytics;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppManager.getInstance().initialize(this);

        new Analytics().deleteBeforeDaysLog(this);
        

    }
}

package com.rifluxyss.app.analyticstracker;

import android.app.Application;

import com.rifluxyss.app.analyticstracking.AppManagerSingleton;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppManagerSingleton.getInstance().initialize(this);

    }
}

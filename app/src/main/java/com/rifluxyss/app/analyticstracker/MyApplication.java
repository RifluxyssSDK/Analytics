package com.rifluxyss.app.analyticstracker;

import android.app.Application;

import com.rifluxyss.app.analyticstracking.AppManagerSingleton;
import com.rifluxyss.app.analyticstracking.log.Analytics;

import java.io.IOException;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppManagerSingleton.getInstance().initialize(this);

        try {
            new Analytics(getApplicationContext()).deleteBeforeDaysLog();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

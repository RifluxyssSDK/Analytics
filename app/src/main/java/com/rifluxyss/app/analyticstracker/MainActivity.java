package com.rifluxyss.app.analyticstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.rifluxyss.app.analyticstracking.log.Analytics;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Analytics analytics = new Analytics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analytics.insert(create("onCreate",1,"testing Log",1.0f));
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        analytics.insert(create("onRestart",4,"testing Log Restart",4.0f));
    }

    @Override
    protected void onStart() {
        super.onStart();

        analytics.insert(create("onstart",2,"testing Log Start",2.0f));
    }

    @Override
    protected void onResume() {
        super.onResume();

        analytics.insert(create("onResume",3,"testing Log onResume",3.0f));
    }

    @Override
    protected void onPause() {
        super.onPause();

        analytics.insert(create("onPause",5,"testing Log onPause",5.0f));

        List<AnalyticsLog>  analyticsLogs = analytics.getLog();

    }

    @Override
    protected void onStop() {
        super.onStop();

        analytics.insert(create("onStop",6,"testing Log onStop",6.0f));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        analytics.insert(create("onDestroy",7,"testing Log onDestroy",7.0f));
    }

    public static AnalyticsLog create(String message, int eventNumber, String description, float additionalNumber)
    {
        //First part in AddtlDesc is how long the app has been up running
        AnalyticsLog logEntity = new AnalyticsLog();
        logEntity.additionalNumber = additionalNumber;
        //Make sure the fields' length confirms to enterprise server DB schema
        //description is clob
        logEntity.description = description;
        logEntity.message = message;
        logEntity.eventNumber = eventNumber;
        //Session could be not ready when saving to database, make sure to set those fields when uploading
        logEntity.userId = "1";
        logEntity.locationCode = "29";
        logEntity.routeNo = "11";
        //It better to store the host id when log created since we use host id carries version
        logEntity.hostId = "5";
        return logEntity;
    }

}
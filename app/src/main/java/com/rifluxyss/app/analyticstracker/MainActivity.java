package com.rifluxyss.app.analyticstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.rifluxyss.app.analyticstracking.log.Analytics;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Analytics analytics = new Analytics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analytics.insert(create("onCreate","1","testing Log",1.0f,11));
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        analytics.insert(create("onRestart","4","testing Log Restart",4.0f,11));
    }

    @Override
    protected void onStart() {
        super.onStart();

        analytics.insert(create("onstart","2","testing Log Start",2.0f,11));
    }

    @Override
    protected void onResume() {
        super.onResume();

        analytics.insert(create("onResume","3","testing Log onResume",3.0f,11));
    }

    @Override
    protected void onPause() {
        super.onPause();

        analytics.insert(create("onPause","5","testing Log onPause",5.0f,11));

        List<AnalyticsLog>  analyticsLogs = analytics.getLog();

        Log.e("status","check data ===> " + new Gson().toJson(analyticsLogs));

    }

    @Override
    protected void onStop() {
        super.onStop();

        analytics.insert(create("onStop","6","testing Log onStop",6.0f,11));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        analytics.insert(create("onDestroy","7","testing Log onDestroy",7.0f,11));
    }

    public AnalyticsLog create(String message, String eventNumber, String description, Number additionalNumber,Number routeNbr)
    {
        //First part in AddtlDesc is how long the app has been up running
        AnalyticsLog logEntity = new AnalyticsLog();
        logEntity.hostId = "5";
        //Make sure the fields' length confirms to enterprise server DB schema
        //description is clob
        logEntity.userID = "1";
        logEntity.locationNbr = "29";
        logEntity.routNbr = routeNbr;
        logEntity.eventNbr = eventNumber;
        logEntity.addtlDesc = description;
        logEntity.addtlNbr = additionalNumber;
        //Session could be not ready when saving to database, make sure to set those fields when uploading
        logEntity.deviceID = "";
        return logEntity;
    }


}
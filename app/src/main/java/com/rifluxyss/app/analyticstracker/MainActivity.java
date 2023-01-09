package com.rifluxyss.app.analyticstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rifluxyss.app.analyticstracking.Utils;
import com.rifluxyss.app.analyticstracking.log.Analytics;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private Analytics analytics;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analytics = new Analytics();

        analytics.insert(create("onCreate","1","testing Log",1.0f,11));


    }


    @Override
    protected void onStart() {
        super.onStart();

        analytics.insert(create("onstart","2","testing Log Start",2.0f,11));
    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();

        analytics.insert(create("onResume","3","testing Log onResume",3.0f,11));
        LiveData<List<AnalyticsLog>> analyticsLogLiveData = analytics.getDateWeekLogs(LocalDateTime.now().getDayOfWeek().getValue());
        analyticsLogLiveData.observe(this, analyticsLog -> {
            Log.e("status","check Data's ===> " + analyticsLog.size());
        });

        Log.e("status","check Data's start Time===> " +  LocalDateTime.now().minusDays(4));
        Log.e("status","check Data's End time ===> " +  LocalDateTime.now().minusDays(4).minusHours(1));

        LiveData<List<AnalyticsLog>> analyticsLogLiveDataDate = analytics.getSpecificDateTimeLogs( LocalDateTime.now().minusDays(4) ,LocalDateTime.now().minusDays(4).minusHours(1));
        analyticsLogLiveDataDate.observe(this, analyticsLog -> {
            Log.e("status","check Data's DateTime ===> " + analyticsLog.size());
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        analytics.insert(create("onRestart","4","testing Log Restart",4.0,11));
    }


    @Override
    protected void onPause() {
        super.onPause();

        analytics.insert(create("onPause","5","testing Log onPause",5.0f,11));

    }

    @SuppressLint("NewApi")
    @Override
    protected void onStop() {
        super.onStop();

        analytics.insert(create("onStop","6","testing Log onStop",6.0f,11));


    }

    @SuppressLint("NewApi")
    @Override
    protected void onDestroy() {

        Log.e("status","Destroy Called");
        analytics.insert(create("onDestroy","7","testing Log onDestroy",7.0f,11));

        super.onDestroy();
    }

    @SuppressLint("HardwareIds")
    public AnalyticsLog create(String message, String eventNumber, String description, Number additionalNumber, Number routeNbr)
    {
        //First part in AddtlDesc is how long the app has been up running
        AnalyticsLog logEntity = new AnalyticsLog();
        //Make sure the fields' length confirms to enterprise server DB schema
        //description is clob
        logEntity.userID = "1";
        logEntity.locationNbr = "29";
        logEntity.routNbr = routeNbr;
        logEntity.eventNbr = eventNumber;
        logEntity.addtlDesc = String.format("%s %s %s %s", description, Utils.deviceModelCapitalized(Build.MANUFACTURER) , Build.MODEL,Build.VERSION.SDK_INT);
        logEntity.addtlNbr = additionalNumber;
        return logEntity;
    }

}
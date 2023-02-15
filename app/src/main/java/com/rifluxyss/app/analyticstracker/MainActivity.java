package com.rifluxyss.app.analyticstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.rifluxyss.app.analyticstracking.log.Analytics;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;
import com.rifluxyss.app.analyticstracking.upload.Logger;

import java.time.LocalDateTime;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Analytics analytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analytics = new Analytics();

        analytics.insert(create("1", "ID=0d5867ee-1a71-4944-9737-fb906d8b7f9d|currentCustomerHelper Initialized0012702140", 1.0f, 11, "Testkishanth"));

    }


    @Override
    protected void onStart() {
        super.onStart();

        analytics.insert(create("2", "ID=0d5867ee-1a71-4944-9737-fb906d8b7f9d|currentCustomerHelper Initialized0012702140", 2.0f, 11, "Testkishanth"));
    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();

        analytics.insert(create("3", "ID=0d5867ee-1a71-4944-9737-fb906d8b7f9d|currentCustomerHelper Initialized0012702140", 3.0f, 11, "Testkishanth"));

        try {

            List<AnalyticsLog> analyticsLogs1 = analytics.getSpecificDaysLogs(LocalDateTime.now().getDayOfWeek().minus(2).getValue(),
                    LocalDateTime.now().getDayOfWeek().getValue());
            Log.e("status", "Start Day====> " + LocalDateTime.now().getDayOfWeek().minus(2).getValue());
            Log.e("status", "END Day====> " + LocalDateTime.now().getDayOfWeek().minus(0).getValue());
            Log.e("status", "check Size Logs====> " + analyticsLogs1.size());

            List<AnalyticsLog> analyticsLogs = analytics.getAllLog();
            new Logger().uploadLogsAPi(analyticsLogs).observe(this, response ->
                    Log.e("status", "get Response===> " + response != null ? response : "Failure Data")
            );

        } catch (Throwable throwable) {
            Log.e("status", "get Response===> " + throwable.getLocalizedMessage());
            throwable.printStackTrace();
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        analytics.insert(create("4", "ID=0d5867ee-1a71-4944-9737-fb906d8b7f9d|currentCustomerHelper Initialized0012702140", 4.0, 11, "TestAjith"));
    }


    @Override
    protected void onPause() {
        super.onPause();

        analytics.insert(create("5", "ID=0d5867ee-1a71-4944-9737-fb906d8b7f9d|currentCustomerHelper Initialized0012702140", 5.0f, 11, "TestAjith"));

    }

    @Override
    protected void onStop() {
        super.onStop();

        analytics.insert(create("6", "ID=0d5867ee-1a71-4944-9737-fb906d8b7f9d|currentCustomerHelper Initialized0012702140", 6.0f, 11, "TestAjith"));


    }

    @Override
    protected void onDestroy() {

        Log.e("status", "Destroy Called");
        analytics.insert(create("7", "ID=0d5867ee-1a71-4944-9737-fb906d8b7f9d|currentCustomerHelper Initialized0012702140", 7.0f, 11, "TestAjith"));

        super.onDestroy();
    }

    public AnalyticsLog create(String eventNumber, String description, Number
            additionalNumber, Number routeNbr, String userID) {
        //First part in AddtlDesc is how long the app has been up running
        AnalyticsLog logEntity = new AnalyticsLog();
        //Make sure the fields' length confirms to enterprise server DB schema
        //description is clob
        logEntity.userID = userID;
        logEntity.locationNbr = "29";
        logEntity.routNbr = routeNbr;
        logEntity.eventNbr = eventNumber;
        logEntity.addtlDesc = description;
        logEntity.addtlNbr = additionalNumber;
        logEntity.logger = "ANALYTICS test";
        return logEntity;
    }

}
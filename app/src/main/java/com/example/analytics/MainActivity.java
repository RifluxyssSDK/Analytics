package com.example.analytics;

import android.analytics.dataBase.Schema;
import android.analytics.kernel.Analytics;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        @SuppressLint("HardwareIds") String android_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        Analytics.init(getBaseContext(),2);
        Analytics.logInfo(new Schema("ONE", ""));
        Analytics.logInfo(new Schema("TWO", ""));
        Analytics.logInfo(new Schema("THREE", ""));
        Analytics.logInfo(new Schema("$", ""));
        Analytics.logInfo(new Schema("5", ""));

    }
}
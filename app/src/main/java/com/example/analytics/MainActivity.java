package com.example.analytics;

import androidx.appcompat.app.AppCompatActivity;

import android.analytics.Kernel.Analytics;
import android.analytics.constant.Duration;
import android.analytics.dataBase.Schema;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Analytics.init(getBaseContext(), Duration.THREE_DAY);

        Analytics.Log(new Schema("ONE 1"));

//        Analytics.Log(new Model());

        List<Schema> schemas = Analytics.getLog();

        Log.d("TAG", "onCreate: ");
    }
}
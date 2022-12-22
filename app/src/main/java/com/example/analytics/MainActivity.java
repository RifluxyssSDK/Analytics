package com.example.analytics;

import android.analytics.Kernel.Analytics;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Analytics.init(getBaseContext(), 1);

        Analytics.insert(new Pojo(80, 80, 90, 70, 85));
        Analytics.insert(new Pojo(80, 80, 90, 70, 85));
        Analytics.insert(new Pojo(80, 80, 90, 70, 85));

        List<Pojo> pojoList = Analytics.get(Pojo.class);

        Log.d("TAG", "onCreate: ");
    }
}
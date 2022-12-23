package com.example.analytics;

import android.analytics.dataBase.Schema;
import android.analytics.kernel.Analytics;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Analytics.init(getBaseContext(),3);

        Analytics.insertLog(new Schema("Mukesh"));

        List<Schema> schemas = Analytics.getLogs();

        Log.i("TAG", "onCreate: ");
    }
}
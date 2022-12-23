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

        Analytics.init(getBaseContext(),10);

        Analytics.insertLog(new Schema("Mukesh","",243.,"qerr",",asfa","sada","zds"));
        Analytics.insertLog(new Schema("Suresh","dsad",243.,"sadad",",faf","af","af"));
        Analytics.insertLog(new Schema("Raju","dsd",243.,"fsdf","f,","af","af"));

        List<Schema> schemas = Analytics.getLogs();

        Log.i("TAG", "onCreate: ");
    }
}
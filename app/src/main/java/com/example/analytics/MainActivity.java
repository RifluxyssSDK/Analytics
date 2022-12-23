package com.example.analytics;

import android.analytics.dataBase.Schema;
import android.analytics.kernel.Analytics;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Analytics.init(getBaseContext(), 1);

        Analytics.logInfo(new Schema(",",""));

//        Analytics.insert(new Pojo(80, 80, 90, 70, 85));
//        Analytics.insert(new Model("Hello"));
//        Analytics.insert(new Pojo(80, 80, 90, 70, 85));
//        Analytics.insert(new Pojo(80, 80, 90, 70, 85));
//
//        List<Pojo> pojoList = Analytics.get(Pojo.class);
//        List<Model> modelList = Analytics.get(Model.class);

    }
}
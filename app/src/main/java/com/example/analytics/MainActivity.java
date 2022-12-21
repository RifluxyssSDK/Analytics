package com.example.analytics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.os.Bundle;

import com.example.analytics.dataBase.Model;
import com.example.analytics.dataBase.Repository;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository repository = new Repository(getApplicationContext());

        repository.insert(new Model("Mukesh","123"));

        LiveData<ArrayList<Model>> models = repository.getModels();
    }
}
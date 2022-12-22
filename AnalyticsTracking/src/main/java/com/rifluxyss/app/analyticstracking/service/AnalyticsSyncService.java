package com.rifluxyss.app.analyticstracking.service;


import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

public class AnalyticsSyncService extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.e("status","check Data===> " + params.getJobId());
        Toast.makeText(getApplicationContext(), "Job Started", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e("status","check Data Stop ===> " + params.getJobId());
        Toast.makeText(getApplicationContext(), "Job Stopped", Toast.LENGTH_SHORT).show();
        jobFinished(params,true);
        return true;
    }
}

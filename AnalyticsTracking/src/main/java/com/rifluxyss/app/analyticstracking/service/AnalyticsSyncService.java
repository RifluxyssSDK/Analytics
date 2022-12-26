package com.rifluxyss.app.analyticstracking.service;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

import com.rifluxyss.app.analyticstracking.log.Analytics;

import java.io.IOException;


@SuppressLint("SpecifyJobSchedulerIdRange")
public class AnalyticsSyncService extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {

        Toast.makeText(this, "Job Fired ===> : " + params.getJobId(), Toast.LENGTH_LONG).show();
        try {
            new Analytics(getApplicationContext()).deleteBeforeDayLog();
        } catch (IOException e) {
            e.printStackTrace();
        }

        jobFinished(params, true);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e("status","check Data Stop ===> " + params.getJobId());
        Toast.makeText(getApplicationContext(), "Job Stopped", Toast.LENGTH_SHORT).show();
        return true;
    }

}

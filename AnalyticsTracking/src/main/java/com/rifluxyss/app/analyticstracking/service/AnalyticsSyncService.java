package com.rifluxyss.app.analyticstracking.service;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.rifluxyss.app.analyticstracking.log.Analytics;

@SuppressLint("SpecifyJobSchedulerIdRange")
public class AnalyticsSyncService extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {

        Toast.makeText(this, "Job Fired ===> : " + params.getJobId(), Toast.LENGTH_LONG).show();
        new Analytics(getApplicationContext()).deleteBeforeDayLog();

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

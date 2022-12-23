package com.rifluxyss.app.analyticstracking.service;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

@SuppressLint("SpecifyJobSchedulerIdRange")
public class AnalyticsSyncService extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.e("status","check Data===> " + params.getJobId());
        for(int i = 0; i < 10; i++){
            Toast.makeText(this, "Job Fired i : "+i, Toast.LENGTH_SHORT).show();
            SystemClock.sleep(1000);
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

package com.rifluxyss.app.analyticstracking.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

import androidx.work.Configuration;
import com.rifluxyss.app.analyticstracking.log.Analytics;


public class AnalyticsSyncService extends JobService {

    public AnalyticsSyncService() {
        Configuration.Builder builder = new Configuration.Builder();
        builder.setJobSchedulerJobIdRange(0,1000);
        builder.build();
    }

    @Override
    public boolean onStartJob(JobParameters params) {

        Toast.makeText(this, "Job Fired ===> : " + params.getJobId(), Toast.LENGTH_LONG).show();
        new Analytics().deleteBeforeDayLog();

        jobFinished(params, true);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }

}

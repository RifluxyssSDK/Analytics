package com.rifluxyss.app.analyticstracking.log;

import static android.content.Context.JOB_SCHEDULER_SERVICE;
import static java.util.concurrent.TimeUnit.DAYS;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rifluxyss.app.analyticstracking.SignupPojo;
import com.rifluxyss.app.analyticstracking.Utils;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;
import com.rifluxyss.app.analyticstracking.AppManager;
import com.rifluxyss.app.analyticstracking.service.AnalyticsSyncService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Analytics extends AppManager {

    private Context mContext;

    public Analytics(Context mContext) {
        this.mContext = mContext;
    }

    public Analytics() {
    }

    public void insert(AnalyticsLog analyticsLog) {
        localDatabase().analyticsLogDaoLogDao().insert(analyticsLog);
    }

    public List<AnalyticsLog> getLog() {
        return localDatabase().analyticsLogDaoLogDao().getAll();
    }

    public List<AnalyticsLog> getDateLog(LocalDateTime localDateTime) {
        return localDatabase().analyticsLogDaoLogDao().readBefore(localDateTime);
    }

    public List<AnalyticsLog> getAfterDateLog(LocalDateTime localDateTime) {
        return localDatabase().analyticsLogDaoLogDao().readAfter(localDateTime);
    }

    public int deleteBeforeDateLog(LocalDateTime localDateTime) {
        return localDatabase().analyticsLogDaoLogDao().deleteBefore(localDateTime);
    }

    public void deleteAllLog() {
        localDatabase().analyticsLogDaoLogDao().deleteAllLog();
    }

    @SuppressLint("NewApi")
    public void deleteBeforeDayLog() {

        try {

            int analyticsLogs = AppManager.localDatabase().analyticsLogDaoLogDao().readBeforeDateCount(LocalDateTime.now().minusDays(4));

            SignupPojo signupPojo = new SignupPojo("123456", "");
            boolean fileCreated = new Utils().create(new Gson().toJson(signupPojo), mContext);

            Log.e("status", "check fileCreated ===> " + fileCreated);


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    public void deleteBeforeDaysLog() {

        JobScheduler jobScheduler = (JobScheduler) mContext.getSystemService(JOB_SCHEDULER_SERVICE);
        jobScheduler.cancelAll();

        ComponentName mComponentName = new ComponentName(mContext, AnalyticsSyncService.class);

        JobInfo.Builder builder = new JobInfo.Builder(2, mComponentName);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setRequiresCharging(true);
        builder.setPersisted(true);
        builder.setMinimumLatency(DAYS.toDays(Utils.HOUR_SCALE)); // 4 Days duration

        int scheduleStatus = jobScheduler.schedule(builder.build());

        String message = scheduleStatus == JobScheduler.RESULT_SUCCESS ? "Job Schedule Successfully" : "Job Schedule Failed!!";
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

    }

}

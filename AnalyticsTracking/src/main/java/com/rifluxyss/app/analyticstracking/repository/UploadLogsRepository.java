package com.rifluxyss.app.analyticstracking.repository;


import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import com.rifluxyss.app.analyticstracking.api.RestAPi;
import com.rifluxyss.app.analyticstracking.api.RestInterface;

import java.io.IOException;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * The type Upload logs repository.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class UploadLogsRepository {

    private UploadLogsRepository mUploadLogsRepository;

    private final RestInterface mRestInterface;

    /**
     * Get instance upload logs repository.
     *
     * @return the upload logs repository
     */
    public UploadLogsRepository getInstance(){
        if (mUploadLogsRepository == null){
            mUploadLogsRepository = new UploadLogsRepository();
        }
        return mUploadLogsRepository;
    }

    /**
     * Instantiates a new Upload logs repository.
     */
    public UploadLogsRepository(){
        mRestInterface = new RestAPi().getClient(ScalarsConverterFactory.create(),
                HttpLoggingInterceptor.Level.BODY).create(RestInterface.class);
    }


    /**
     * Upload logs mutable live data.
     *
     * @param logsPayLoad the logs pay load
     * @return the mutable live data
     */
    public MutableLiveData<String> uploadLogs(String logsPayLoad) {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(() -> {
            Call call = mRestInterface.uploadAnalyticsLogs(logsPayLoad);

            try {
                Response response = call.execute();
                String responseData = response.isSuccessful() && response.body() != null ? response.body().toString() : null;
                mutableLiveData.postValue(responseData);

            } catch (IOException e) {
                e.printStackTrace();
                mutableLiveData.postValue(e.getLocalizedMessage());
            }
        });

        return mutableLiveData;
    }
}

package com.rifluxyss.app.analyticstracking.repository;


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
     * @throws IOException the io exception
     */
    public MutableLiveData<String> uploadLogs(String logsPayLoad) throws IOException{
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        Call call = mRestInterface.uploadAnalyticsLogs(logsPayLoad);
        Response response = call.execute();
        String responseData = response.isSuccessful() && response.body() != null ?  response.body().toString() : null;
        mutableLiveData.postValue(responseData);
        return mutableLiveData;
    }
}

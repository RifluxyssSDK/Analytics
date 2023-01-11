package com.rifluxyss.app.analyticstracking.repository;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.rifluxyss.app.analyticstracking.api.RestAPi;
import com.rifluxyss.app.analyticstracking.api.RestInterface;

import java.io.IOException;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class UploadLogsRepository {

    private UploadLogsRepository mUploadLogsRepository;

    private RestInterface mRestInterface;

    public UploadLogsRepository getInstance(){
        if (mUploadLogsRepository == null){
            mUploadLogsRepository = new UploadLogsRepository();
        }
        return mUploadLogsRepository;
    }

    public UploadLogsRepository(){
        mRestInterface = new RestAPi().getClient(ScalarsConverterFactory.create(),
                HttpLoggingInterceptor.Level.BODY).create(RestInterface.class);
    }


    public MutableLiveData<String> uploadLogs(String logsPayLoad) throws IOException{
        final MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

        Call call = mRestInterface.uploadAnalyticsLogs(logsPayLoad);
        Response response = call.execute();
        if (response.isSuccessful())
        {
            mutableLiveData.postValue(new Gson().toJson(response.body()));
        }
        else
        {
            mutableLiveData.postValue(null);
        }
        return mutableLiveData;
    }
}

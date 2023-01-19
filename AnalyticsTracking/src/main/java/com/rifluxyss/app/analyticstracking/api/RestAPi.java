package com.rifluxyss.app.analyticstracking.api;

import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class of RestAPI
 */
public class RestAPi {

    /**
     * @param converterFactory of Converter.Factory
     * @param level of HttpLoggingInterceptor.Level
     * @return Retrofit
     */
    @NonNull
    public Retrofit getClient(Converter.Factory converterFactory, HttpLoggingInterceptor.Level level) {
        //Initialize the variable of API URL String
        MutableLiveData<String> UploadLogsURL = new MutableLiveData<>("https://cpas100.na.cintas.com/");
        //Initialize the Retrofit.Builder of class with variable
        return new Retrofit.Builder().baseUrl(UploadLogsURL.getValue()).callbackExecutor(AsyncTask.THREAD_POOL_EXECUTOR).addConverterFactory(GsonConverterFactory.create()).client(createClient(level)).addConverterFactory(converterFactory).build();
    }

    /**
     * @param level of HttpLoggingInterceptor.Level
     * @return OkHttpClient
     */
    @NonNull
    static OkHttpClient createClient(HttpLoggingInterceptor.Level level) {
        //object creation of HttpLoggingInterceptor class
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(level);
        //object creation of HttpLoggingInterceptor class
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        return httpClientBuilder.build();
    }

}

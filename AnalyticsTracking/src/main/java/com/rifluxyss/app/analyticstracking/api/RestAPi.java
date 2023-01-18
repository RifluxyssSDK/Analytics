package com.rifluxyss.app.analyticstracking.api;

import android.os.AsyncTask;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Collections;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPi {

    public Retrofit getClient(Converter.Factory converterFactory, HttpLoggingInterceptor.Level level) {
        String UploadLogsURL = "https://cpas100.na.cintas.com/";
        return new Retrofit.Builder().baseUrl(UploadLogsURL).callbackExecutor(AsyncTask.THREAD_POOL_EXECUTOR).addConverterFactory(GsonConverterFactory.create()).client(createClient(level)).addConverterFactory(converterFactory).build();
    }

    static OkHttpClient createClient(HttpLoggingInterceptor.Level level) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(level);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        return httpClientBuilder.build();
    }

}

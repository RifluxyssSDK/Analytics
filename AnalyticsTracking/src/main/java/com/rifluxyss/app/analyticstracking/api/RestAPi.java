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

    private final String UPLOADLOGS_URL = "https://cpas100.na.cintas.com/";

    public Retrofit getClient(Converter.Factory converterFactory, HttpLoggingInterceptor.Level level) {
        return new Retrofit.Builder().baseUrl(UPLOADLOGS_URL).callbackExecutor(AsyncTask.THREAD_POOL_EXECUTOR).addConverterFactory(GsonConverterFactory.create()).client(createClient(level,false)).addConverterFactory(converterFactory).build();
    }

    static OkHttpClient createClient(HttpLoggingInterceptor.Level level, boolean isHttps) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(level);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        if (isHttps) {
            try {

                X509TrustManager x509TrustManager = new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }
                };
                final TrustManager[] trustAllCerts = new TrustManager[]{x509TrustManager};
                final SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, trustAllCerts, new SecureRandom());
                httpClientBuilder.connectionSpecs(Collections.singletonList(ConnectionSpec.COMPATIBLE_TLS));
                httpClientBuilder.sslSocketFactory(sslContext.getSocketFactory(), x509TrustManager);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return httpClientBuilder.build();
    }

}

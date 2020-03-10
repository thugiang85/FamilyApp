package com.example.familyapp.network;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sandy on 09/03/2020.
 */
public class RetrofitManger {

    private final static long CONNECT_TIMEOUT = 180; // ms
    private final static long READ_TIMEOUT = 180; // ms
    private final static long WRITE_TIMEOUT = 180; // ms

    private static RetrofitManger manger;
    private Retrofit retrofit;

    private RetrofitManger() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://52.221.204.195/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient())
                .build();
    }

    public static synchronized RetrofitManger getInstance() {
        if (manger == null) {
            manger = new RetrofitManger();
        }
        return manger;
    }

    private OkHttpClient getClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient().newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .callTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    public APIs getService() {
        return retrofit.create(APIs.class);
    }
}

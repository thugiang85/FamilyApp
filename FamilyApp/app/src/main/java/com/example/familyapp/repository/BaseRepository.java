package com.example.familyapp.repository;

import android.content.Context;

import com.example.familyapp.network.APIs;
import com.example.familyapp.network.RetrofitManger;

import retrofit2.Retrofit;

/**
 * Created by Sandy on 09/03/2020.
 */
public abstract class BaseRepository {

    protected Context context;
    protected APIs service;

    public BaseRepository(Context context) {
        this.context = context;
        service = RetrofitManger.getInstance().getService();
    }
}

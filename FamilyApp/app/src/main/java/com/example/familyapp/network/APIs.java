package com.example.familyapp.network;

import com.google.gson.JsonObject;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Sandy on 09/03/2020.
 */
public interface APIs {

    @POST("ninja/login")
    Single<Completable> login(@Body JsonObject body);
}

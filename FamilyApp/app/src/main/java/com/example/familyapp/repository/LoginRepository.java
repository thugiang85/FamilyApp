package com.example.familyapp.repository;

import android.content.Context;

import com.google.gson.JsonObject;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Sandy on 09/03/2020.
 */
public class LoginRepository extends BaseRepository {

    public LoginRepository(Context context) {
        super(context);
    }

    public Single<Completable> login(String email, String password) {
        JsonObject body = new JsonObject();
        body.addProperty("email", email);
        body.addProperty("password", password);
        return service.login(body);
    }
}

package com.example.familyapp.viewmodel.login;

import androidx.lifecycle.LiveData;

import com.example.familyapp.viewmodel.base.IViewModel;

/**
 * Created by Sandy on 09/03/2020.
 */
public interface ILoginViewModel extends IViewModel {
    LiveData<Boolean> isLoginSuccess();
    void login(String email, String password);
}

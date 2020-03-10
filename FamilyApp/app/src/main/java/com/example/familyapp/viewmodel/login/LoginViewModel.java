package com.example.familyapp.viewmodel.login;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.familyapp.repository.LoginRepository;
import com.example.familyapp.viewmodel.base.BaseViewModel;

import io.reactivex.Completable;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Sandy on 09/03/2020.
 */
public class LoginViewModel extends BaseViewModel implements ILoginViewModel {
    private LoginRepository repository;
    private MutableLiveData<Boolean> _isLoginSuccess = new MutableLiveData<>();

    public LoginViewModel(Context context) {
        super(context);
        repository = new LoginRepository(context);
    }

    @Override
    public LiveData<Boolean> isLoginSuccess() {
        return _isLoginSuccess;
    }

    @SuppressLint("CheckResult")
    @Override
    public void login(String email, String password) {
        repository.login(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Completable>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        isLoading.postValue(true);
                        addDisposable(d);
                    }

                    @Override
                    public void onSuccess(Completable completable) {
                        _isLoginSuccess.postValue(true);
                        isLoading.postValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        error.postValue(e);
                    }
                });
    }
}

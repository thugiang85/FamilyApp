package com.example.familyapp.viewmodel.base;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Sandy on 09/03/2020.
 */
public abstract class BaseViewModel extends ViewModel implements IViewModel, LifecycleObserver {

    protected Context context;

    private CompositeDisposable compositeDisposable;
    protected MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    protected MutableLiveData<Throwable> error = new MutableLiveData<>();

    public BaseViewModel(Context context) {
        this.context = context;
    }

    protected void addDisposable(Disposable disposable) {
        if (compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    @Override
    public LiveData<Boolean> isLoading() {
        return isLoading;
    }

    @Override
    public LiveData<Throwable> onError() {
        return error;
    }

    @Override
    public void onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    @Override
    public void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    @Override
    public void onPause() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    @Override
    public void onResume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    @Override
    public void onStop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void onDestroy() {
        if (!compositeDisposable.isDisposed()) compositeDisposable.dispose();
    }
}

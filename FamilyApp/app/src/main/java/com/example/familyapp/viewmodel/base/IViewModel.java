package com.example.familyapp.viewmodel.base;

import androidx.lifecycle.LiveData;

/**
 * Created by Sandy on 09/03/2020.
 */
public interface IViewModel {

    LiveData<Boolean> isLoading();

    LiveData<Throwable> onError();

    void onCreate();

    void onStart();

    void onPause();

    void onResume();

    void onStop();

    void onDestroy();
}

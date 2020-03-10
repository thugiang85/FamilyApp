package com.example.familyapp.view.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;

import com.example.familyapp.viewmodel.base.IViewModel;

/**
 * Created by  on 09/03/2020.
 */
public abstract class BaseActivity<T extends IViewModel> extends AppCompatActivity {
    protected T mViewModel;
    protected NavController navController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        mViewModel = getViewModel();
        initView();
        initViewModel();

    }

    protected void setViewModel(T viewModel) {
        this.mViewModel = viewModel;
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract T getViewModel();

    protected void setNavController(NavController navController) {
        this.navController = navController;
    }

    protected void initView() {
    }

    protected void initViewModel() {
        mViewModel = getViewModel();
        if (mViewModel != null) {
            setViewModel(getViewModel());
            getLifecycle().addObserver((LifecycleObserver) mViewModel);
            mViewModel.isLoading().observe(this, new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean aBoolean) {
                    showLoading(aBoolean);
                }
            });
            mViewModel.onError().observe(this, new Observer<Throwable>() {
                @Override
                public void onChanged(Throwable t) {
                    handelError(t);
                }
            });
        }
    }

    protected void showLoading(boolean isShow) {
        if (isShow) {
            Toast.makeText(this, "Progress bar showing", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Progress bar dismiss", Toast.LENGTH_SHORT).show();
        }
    }

    protected void handelError(Throwable t) {
        Toast.makeText(this, "Error here!", Toast.LENGTH_SHORT).show();
    }
}

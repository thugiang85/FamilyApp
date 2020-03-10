package com.example.familyapp.view.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;

import com.example.familyapp.R;
import com.example.familyapp.viewmodel.base.IViewModel;

/**
 * Created by  on 09/03/2020.
 */
public abstract class BaseFragment<T extends IViewModel> extends Fragment {
    protected T mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = getView();
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutRes(), container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view, savedInstanceState);
        initViewModel();
    }

    protected void setViewModel(T viewModel) {
        this.mViewModel = viewModel;
    }

    /**
     * Important
     * @return
     */
    @LayoutRes
    protected abstract int getLayoutRes();

    /**
     * Important
     * @param view
     * @param savedInstanceState
     */
    protected abstract void initView(@NonNull View view, @Nullable Bundle savedInstanceState);

    /**
     * Not important
     * @return
     */
    protected abstract T getViewModel();

    /**
     * Not important
     */
    protected void initViewModel() {
        mViewModel = getViewModel();
        if (mViewModel != null) {
            setViewModel(getViewModel());
            getLifecycle().addObserver((LifecycleObserver) mViewModel);
            mViewModel.isLoading().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean aBoolean) {
                    showLoading(aBoolean);
                }
            });
            mViewModel.onError().observe(getViewLifecycleOwner(), new Observer<Throwable>() {
                @Override
                public void onChanged(Throwable t) {
                    handelError(t);
                }
            });
        }
    }

    protected void showLoading(boolean isShow) {
        if (getActivity() != null && isAdded()) {
            ((BaseActivity) getActivity()).showLoading(isShow);
        }
    }

    protected void handelError(Throwable t) {
        if (getActivity() != null && isAdded()) {
            ((BaseActivity) getActivity()).handelError(t);
        }
    }
}

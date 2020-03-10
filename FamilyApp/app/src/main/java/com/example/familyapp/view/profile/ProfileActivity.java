package com.example.familyapp.view.profile;

import com.example.familyapp.R;
import com.example.familyapp.view.base.BaseActivity;
import com.example.familyapp.viewmodel.base.IViewModel;

public class ProfileActivity extends BaseActivity<IViewModel> {
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_profile;
    }

    @Override
    protected IViewModel getViewModel() {
        return null;
    }
}

package com.example.familyapp.view.main.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyapp.R;
import com.example.familyapp.view.base.BaseFragment;
import com.example.familyapp.view.profile.ProfileActivity;
import com.example.familyapp.viewmodel.base.IViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class AccountFragment extends BaseFragment<IViewModel> {


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_account;
    }

    @Override
    protected IViewModel getViewModel() {
        return null;
    }

    @Override
    protected void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        AppCompatTextView tvEditProfile = view.findViewById(R.id.tv_edit_profile);
        tvEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ProfileActivity.class)); }
        });
    }


}
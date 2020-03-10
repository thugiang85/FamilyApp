package com.example.familyapp.view.main.glasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.familyapp.R;
import com.example.familyapp.view.base.BaseFragment;
import com.example.familyapp.view.profile.ProfileActivity;
import com.example.familyapp.viewmodel.base.IViewModel;

public class GlassesFragment extends BaseFragment<IViewModel> {


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_glasses;
    }

    @Override
    protected IViewModel getViewModel() {
        return null;
    }

    @Override
    protected void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final TextView textView = view.findViewById(R.id.text_glasses);
        textView.setText(getString(R.string.title_glasses));
    }

}

package com.example.familyapp.view.main.group;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.familyapp.R;
import com.example.familyapp.view.base.BaseFragment;
import com.example.familyapp.viewmodel.base.IViewModel;

public class GroupFragment extends BaseFragment<IViewModel> {

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_group;
    }

    @Override
    protected IViewModel getViewModel() {
        return null;
    }

    @Override
    protected void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final TextView textView = view.findViewById(R.id.text_group);
        textView.setText(getString(R.string.title_group));
    }
}

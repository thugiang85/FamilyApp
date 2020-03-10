package com.example.familyapp.view.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.familyapp.R;

public class FirstInfoFragment extends Fragment {
    private String title;
    private int page;

    public static FirstInfoFragment newInstance(int page, String title){
        FirstInfoFragment glasses1Fragment = new FirstInfoFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        glasses1Fragment.setArguments(args);
        return glasses1Fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_firstinfo, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.text_mapinfo2);
        tvLabel.setText(page + " -- " + title);
        return view;
    }
}

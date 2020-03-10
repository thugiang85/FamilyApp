package com.example.familyapp.view.main.home;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPageAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;

    public MyPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return FirstInfoFragment.newInstance(0, "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return SecondInfoFragment.newInstance(1, "Page # 2");
            default:
                return null;
        }
    }
    @Override
    public CharSequence getPageTitle(int position){
        return "Page " + position;
    }
}

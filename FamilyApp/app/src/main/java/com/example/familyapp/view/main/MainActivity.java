package com.example.familyapp.view.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.example.familyapp.R;
import com.example.familyapp.view.base.BaseActivity;
import com.example.familyapp.view.main.home.MyPageAdapter;
import com.example.familyapp.viewmodel.base.IViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity<IViewModel> {
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected IViewModel getViewModel() {
        return null;
    }

    @Override
    protected void initView() {
        super.initView();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_group, R.id.navigation_notifications, R.id.navigation_account, R.id.navigation_glasses)
                .build();
        setNavController(Navigation.findNavController(this, R.id.nav_host_fragment));
        NavigationUI.setupWithNavController(navView, navController);
    }

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_home);
//
//        ViewPager viewPager = findViewById(R.id.view_pager);
//        adapterViewPager = new MyPageAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(adapterViewPager);
//
//        viewPager.getCurrentItem();
//        viewPager.setCurrentItem(2);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//            @Override
//            public void onPageSelected(int position) {
//            }
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//        });
//   }
}

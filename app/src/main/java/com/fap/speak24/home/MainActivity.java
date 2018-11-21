package com.fap.speak24.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.fap.speak24.BaseActivity;
import com.fap.speak24.R;
import com.fap.speak24.favorite.FavoriteFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolBar;
    @Override
    protected void initView(Bundle bundle) {
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        toolBar.setTitle(R.string.app_name);
        setSupportActionBar(toolBar);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) return new HomeFragment();
            return new FavoriteFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) return "Online";
            return "Favorite";
        }
    }
}

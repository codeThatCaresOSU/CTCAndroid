package com.gustafson.ctcandroid_new;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

public class MainActivity extends AppCompatActivity {

    static final int NUM_ITEMS = 3;
    MyAdapter mAdapter;
    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager_view);
        mPager.setAdapter(mAdapter);
        //mPager.setBackgroundResource(R.drawable.bg);
        final BubbleNavigationConstraintView bubView = (BubbleNavigationConstraintView) findViewById(R.id.top_navigation_constraint);
        bubView.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                mPager.setCurrentItem(position);
            }
        });
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                bubView.setCurrentActiveItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                //bubView.setCurrentActiveItem(i);
            }
        });
    }

    public static class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount(){
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment;
            if(position == 0) {
                fragment = new ListViewFragment();
            } else if(position == 1){
                fragment = new RightScreenFragment();
            } else {
                fragment = new SponsorsFragment();
            }
            return fragment;
        }
    }
}

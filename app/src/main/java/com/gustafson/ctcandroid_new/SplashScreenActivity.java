package com.gustafson.ctcandroid_new;

import android.os.Bundle;
import android.support.constraint.motion.MotionLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


public class SplashScreenActivity extends FragmentActivity {
    MotionLayout motionLayout;

    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.splash_screen_view_container);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        SplashScreenFragment ssf = new SplashScreenFragment();
        ft.add(R.id.fragment_container, ssf);
        ft.commit();

    }

}

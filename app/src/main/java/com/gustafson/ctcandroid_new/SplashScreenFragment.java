package com.gustafson.ctcandroid_new;

import android.os.Bundle;
import android.support.constraint.motion.MotionLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreenFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances){
        final View rootview = inflater.inflate(R.layout.splash_screen_activity, container, false);
        final LottieAnimationView heart = (LottieAnimationView) rootview.findViewById(R.id.heart_animation);

        MotionLayout motionLayout = (MotionLayout) rootview.findViewById(R.id.motionLayout);

        heart.setMinFrame(4);
        heart.setMaxFrame(20);
        motionLayout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {

            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {
                heart.setProgress(v);
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {
                //this is called every time the user 'stops' moving the screen
                //make sure the user moved it as much as 95% to show the next fragment
                if(motionLayout.getProgress() > .95){
                    AboutUsFragment auf = new AboutUsFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container, auf);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {

            }
        });
        return rootview;
    }
}

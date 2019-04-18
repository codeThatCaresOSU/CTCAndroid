package com.gustafson.ctcandroid_new;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class RightScreenFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.right_view_fragment, container, false);
<<<<<<< Updated upstream
        ((TextView) rootview.findViewById(R.id.fragment_2_textview)).setText("Fragment Number Two");
=======
        //((TextView) rootview.findViewById(R.id.fragment_2_textview)).setText("Settings Fragment");
        //save the value of the switch to the saved preferences, then use that to determine if notifications should be displayed
        //todo switch notifcation shiet
        Switch sw = rootview.findViewById(R.id.notification_switch);
        Button b = rootview.findViewById(R.id.replay_splash_screen);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SplashScreenActivity.class);
                //starting this activity will cause te app to crash, probably have to do something
                //with fragment manager
                //startActivity(intent);
            }
        });
>>>>>>> Stashed changes
        return rootview;
    }
}
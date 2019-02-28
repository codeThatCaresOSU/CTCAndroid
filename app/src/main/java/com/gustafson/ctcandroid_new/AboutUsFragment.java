package com.gustafson.ctcandroid_new;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AboutUsFragment extends Fragment {
    Button b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances){
        final View rootview = inflater.inflate(R.layout.about_us_fragment, container, false);
        b = rootview.findViewById(R.id.get_started_button);
        final Intent mainApp = new Intent(getContext(), MainActivity.class);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mainApp);
            }
        });
        return rootview;
    }
}

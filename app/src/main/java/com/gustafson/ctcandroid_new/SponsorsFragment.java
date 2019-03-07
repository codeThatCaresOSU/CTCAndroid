package com.gustafson.ctcandroid_new;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SponsorsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.sponsors_fragment, container, false);
        ((TextView) rootview.findViewById(R.id.sponsors_text_view)).setText("Sponsors Fragment");
        return rootview;
    }
}
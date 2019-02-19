package com.gustafson.ctcandroid_new;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RightScreenFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.right_view_fragment, container, false);
        ((TextView) rootview.findViewById(R.id.fragment_2_textview)).setText("Fragment Number Two");
        return rootview;
    }
}
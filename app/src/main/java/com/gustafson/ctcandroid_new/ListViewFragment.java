package com.gustafson.ctcandroid_new;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances){
        View rootview = inflater.inflate(R.layout.list_view_fragment, container, false);
        ((TextView) rootview.findViewById(R.id.fragment_1_textview)).setText("Fragment Number One");
        return rootview;
    }
}

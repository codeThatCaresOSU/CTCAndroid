package com.gustafson.ctcandroid_new;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances){
        View rootview = inflater.inflate(R.layout.list_view_fragment, container, false);
        //((TextView) rootview.findViewById(R.id.fragment_1_textview)).setText("Fragment Number One");
        ArrayList<CTCEvents> eventsList = new ArrayList<CTCEvents>();

        //this is where data would likely be added 

        eventsList.add(new CTCEvents("Test name", "TayTow2", "right now", "420"));
        eventsList.add(new CTCEvents("Test name TOO", "Code that cares classroom", "uh", "soon"));
        eventsList.add(new CTCEvents("Test name", "TayTow2", "right now", "420"));
        eventsList.add(new CTCEvents("Test name TOO", "Code that cares classroom", "uh", "soon"));
        eventsList.add(new CTCEvents("Test name", "TayTow2", "right now", "420"));
        eventsList.add(new CTCEvents("Test name TOO", "Code that cares classroom", "uh", "soon"));
        eventsList.add(new CTCEvents("Test name", "TayTow2", "right now", "420"));
        eventsList.add(new CTCEvents("Test name TOO", "Code that cares classroom", "uh", "soon"));
        eventsList.add(new CTCEvents("Test name", "TayTow2", "right now", "420"));
        eventsList.add(new CTCEvents("Test name TOO", "Code that cares classroom", "uh", "soon"));
        eventsList.add(new CTCEvents("Test name", "TayTow2", "right now", "420"));
        eventsList.add(new CTCEvents("Test name TOO", "Code that cares classroom", "uh", "soon"));
        eventsList.add(new CTCEvents("Test name", "TayTow2", "right now", "420"));
        eventsList.add(new CTCEvents("Test name TOO", "Code that cares classroom", "uh", "soon"));
        ((ListView) rootview.findViewById(R.id.list_view)).setAdapter(new ListViewAdapter(getContext(), eventsList));
        return rootview;
    }
}

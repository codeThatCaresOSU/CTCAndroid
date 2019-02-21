package com.gustafson.ctcandroid_new;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ListViewFragment extends Fragment {
    private FirebaseFirestore db;
    private CollectionReference mDocRef;
    ArrayList<Event> eventsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances){
        final View rootview = inflater.inflate(R.layout.list_view_fragment, container, false);
        //((TextView) rootview.findViewById(R.id.fragment_1_textview)).setText("Fragment Number One");
         eventsList = new ArrayList<Event>();

        db = FirebaseFirestore.getInstance();


        mDocRef = db.collection("events");

        mDocRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    Event event = documentSnapshot.toObject(Event.class);
                    eventsList.add(event);
                    //Log.e("test", event.getName());
                    ((ListView) rootview.findViewById(R.id.list_view)).setAdapter(new ListViewAdapter(getContext(), eventsList));
                }
            }
        });
        //((ListView) rootview.findViewById(R.id.list_view)).setAdapter(new ListViewAdapter(getContext(), eventsList));
        return rootview;
    }
}

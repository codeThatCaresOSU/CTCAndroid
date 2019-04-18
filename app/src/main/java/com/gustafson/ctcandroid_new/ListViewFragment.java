package com.gustafson.ctcandroid_new;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
<<<<<<< Updated upstream
import android.widget.TextView;
=======

import org.json.JSONArray;
import org.json.JSONObject;
>>>>>>> Stashed changes

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ListViewFragment extends Fragment {
<<<<<<< Updated upstream
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
=======
    private static String url = "https://us-central1-ctcios.cloudfunctions.net/getAllEvents";
    private ArrayList<CTCEvents> ctcEvents;
    ListView ls;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances){
        final View rootview = inflater.inflate(R.layout.list_view_fragment, container, false);
        ctcEvents = new ArrayList<>();
        ls = (ListView) rootview.findViewById(R.id.list_view);
        new getJsonData().execute(url);
        //((ListView) rootview.findViewById(R.id.list_view)).setAdapter(new ListViewAdapter(getContext(), ctcEvents));
        return rootview;
    }

    private class getJsonData extends AsyncTask<String, Void, ArrayList<CTCEvents>> {
        @Override
        protected void onPreExecute(){

        }

        @Override
        protected ArrayList<CTCEvents> doInBackground(String... urlString){
            URL url;
            StringBuffer response = new StringBuffer();
            try {
                url = new URL(urlString[0]);
            } catch (MalformedURLException e){
                throw new IllegalArgumentException("invalid url");
            }
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(false);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
                int status = conn.getResponseCode();
                if (status != 200){
                    throw new IOException("Post failed with error code " + status);
                } else {
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                if (conn != null){
                    conn.disconnect();
                }
            }
            return formatToJson(response.toString());
        }

        @Override
        protected void onPostExecute(ArrayList<CTCEvents> events){
            ls.setAdapter(new ListViewAdapter(getContext(), events));
        }

        private ArrayList<CTCEvents> formatToJson(String s){
            ArrayList<CTCEvents> eventsList = new ArrayList<>();
            try {
                JSONArray response = new JSONArray(s);
                for(int i = 0; i < response.length(); i++){
                    JSONObject json = response.getJSONObject(i);
                    CTCEvents CTCEvents = new CTCEvents();
                    CTCEvents.setTimeStamp(json.getInt("timeStamp"));
                    CTCEvents.setDisplayColor(json.getString("displayColor"));
                    CTCEvents.setDetail(json.getString("detail"));
                    CTCEvents.setDurationMinutes(json.getInt("durationMinutes"));
                    CTCEvents.setTitle(json.getString("title"));
                    CTCEvents.setLocation(json.getString("location"));
                    eventsList.add(CTCEvents);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return eventsList;
        }
>>>>>>> Stashed changes
    }
}

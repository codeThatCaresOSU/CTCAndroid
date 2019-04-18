package com.gustafson.ctcandroid_new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<CTCEvents> {
    public ListViewAdapter(Context context, ArrayList<CTCEvents> events){
        super(context, 0, events);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.ctc_event_list_item, parent, false);
        }
        CTCEvents event = getItem(position);
        TextView name = (TextView) listItemView.findViewById(R.id.name_list_item);
        TextView date = (TextView) listItemView.findViewById(R.id.date_list_item);
        TextView time = (TextView) listItemView.findViewById(R.id.time_list_item);
        TextView place = (TextView) listItemView.findViewById(R.id.location_list_item);
<<<<<<< Updated upstream
        name.setText(event.getEventName());
        date.setText(event.getDate());
        time.setText(event.getTime());
=======
        name.setText(event.getTitle());
        //date.setText(event.getTimeStamp());
        //time.setText(event.getTimeStamp());
>>>>>>> Stashed changes
        place.setText(event.getLocation());
        return listItemView;
    }
}

package com.gustafson.ctcandroid_new;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.GeoPoint;

public class Event {

    private String name;
    private String locationStreet;
    private int length;
    private GeoPoint locationCoordinate;
    private Timestamp beginTimeStamp;

    public Event(){

    }

    //constructor
    public Event(String name, String locationStreet, GeoPoint locationCoordinate, int length, Timestamp beginTimeStamp){
        this.name = name;
        this.locationStreet = locationStreet;
        this.length = length;
        this.locationCoordinate = locationCoordinate;
        this.beginTimeStamp = beginTimeStamp;
    }


    //set up getters
    public String getName(){
        return name;
    }

    public String getLocationStreet(){
        return locationStreet;
    }

    public GeoPoint getLocationCoordinate(){
        return locationCoordinate;
    }

    public int getLength(){
        return length;
    }

    public Timestamp getBeginTimeStamp(){
        return beginTimeStamp;
    }


}

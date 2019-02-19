package com.gustafson.ctcandroid_new;

public class CTCEvents {
    String mBeginTime;
    String mLocation;
    String mEventName;
    String mDate;
    public CTCEvents(String name, String location, String date, String time){
        mBeginTime = time;
        mLocation = location;
        mDate = date;
        mEventName = name;
    }
    public String getTime(){
        return mBeginTime;
    }

    public String getDate() {
        return mDate;
    }

    public String getEventName() {
        return mEventName;
    }

    public String getLocation() {
        return mLocation;
    }
}

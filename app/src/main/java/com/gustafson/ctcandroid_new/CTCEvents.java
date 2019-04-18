package com.gustafson.ctcandroid_new;

public class CTCEvents {
<<<<<<< Updated upstream
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
=======

    private String detail;
    private String displayColor;
    private int durationMinutes;
    private String title;
    private String location;
    private double TimeStamp;

    public CTCEvents(){

    }

    //constructor

    public CTCEvents(String detail, String displayColor, int durationMinutes, String title, String location, int timeStamp) {
        this.detail = detail;
        this.displayColor = displayColor;
        this.durationMinutes = durationMinutes;
        this.title = title;
        this.location = location;
        TimeStamp = timeStamp;
    }

    //getter
    public String getDetail() {
        return detail;
    }

    public String getDisplayColor() {
        return displayColor;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public double getTimeStamp() {
        return TimeStamp;
    }

    //setter
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setDisplayColor(String displayColor) {
        this.displayColor = displayColor;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTimeStamp(double timeStamp) {
        TimeStamp = timeStamp;
>>>>>>> Stashed changes
    }
}

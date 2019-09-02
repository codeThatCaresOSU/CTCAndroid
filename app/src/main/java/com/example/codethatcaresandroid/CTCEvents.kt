package com.example.codethatcaresandroid

import org.json.JSONObject

public class CTCEvents (val title: String, val location: String, val detail: String, val displayColor: String, val startTime: Long, val duration: Int) {
    constructor(jsonObj: JSONObject) : this(
        jsonObj.getString("title"),
        jsonObj.getString("location"),
        jsonObj.getString("detail"),
        jsonObj.getString("displayColor"),
        jsonObj.getLong("timeStamp"),
        jsonObj.getInt("durationMinutes"))
}
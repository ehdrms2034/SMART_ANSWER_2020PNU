package com.example.smart_answer.ui.notifications;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NotificationData {
    private String response;
    private String message;
    @SerializedName("data")
    List<NotificationDataFormat> data;

    public NotificationData( String name, String id, List<NotificationDataFormat> data) {
        this.response = name;
        this.message = id;
        this.data = data;
    }

    public String getName() {return response;}
    public String getId() {return message;}
    public List<NotificationDataFormat> getData() {return data;}

}

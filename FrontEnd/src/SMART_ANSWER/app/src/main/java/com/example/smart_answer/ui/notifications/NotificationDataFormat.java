package com.example.smart_answer.ui.notifications;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NotificationDataFormat {
    @SerializedName("title")
    String title;
    @SerializedName("date")
    String date;
    @SerializedName("context")
    String context;

    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getContext() { return context; }
}

package com.example.smart_answer.ui.dashboard;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class DashboardData {
    private String response;
    private String message;
    private ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

}

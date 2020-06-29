package com.example.smart_answer.ui.dashboard;

import java.util.ArrayList;

public class Data {
    private ID _id;
    private String owner;
    private String date;
    private String wrong_count;
    private String answer_count;
    private ArrayList<String> correct_word;
    private ArrayList<String> mean_word;
    private ArrayList<String> my_word;

    public ArrayList<String> getCorrect_word() {
        return correct_word;
    }
    public ArrayList<String> getMean_word() {
        return mean_word;
    }
    public ArrayList<String> getMy_word() {
        return my_word;
    }
    public String getWrong_count() {
        return wrong_count;
    }
    public ID get_id() {
        return _id;
    }
}
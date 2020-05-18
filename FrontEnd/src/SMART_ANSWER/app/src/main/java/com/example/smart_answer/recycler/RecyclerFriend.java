package com.example.smart_answer.recycler;

import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.smart_answer.ui.chatting.ChattingView;

public class RecyclerFriend extends Fragment {
    private int image ;
    private String name;
    private String talks;
    private int id;

    public RecyclerFriend() {

    }

    public RecyclerFriend(int image, String name, String talks){
        this.image = image;
        this.name = name;
        this.talks = talks;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTalks(String talks) {
        this.talks = talks ;
    }

    public int getImage() {
        return this.image ;
    }
    public String getName() {
        return this.name;
    }
    public String getTalks() {
        return this.talks;
    }

}

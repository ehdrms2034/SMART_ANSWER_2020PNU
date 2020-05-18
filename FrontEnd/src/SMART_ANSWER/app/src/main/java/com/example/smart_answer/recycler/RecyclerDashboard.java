package com.example.smart_answer.recycler;

import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.smart_answer.ui.chatting.ChattingView;

public class RecyclerDashboard extends Fragment {
    private int image ;
    private String day;
    private String word;
    private String answer;
    private String wrong_answer;
    private int id;

    public RecyclerDashboard() {

    }

    public RecyclerDashboard(int _image, String _day, String _word, String _answer, String _wrong_answer){
        this.image = _image;
        this.day = _day;
        this.word = _word;
        this.answer = _answer;
        this.wrong_answer = _wrong_answer;
    }

    public void setImage(int image) { this.image = image; }
    public void setDay(String day) { this.day = day; }
    public void setWord(String word) { this.word = word ; }
    public void setAnswer(String answer) { this.answer = answer; }
    public void setWrong_answer(String Wrong_answer) {this.wrong_answer = wrong_answer; }

    public int getImage() {
        return this.image ;
    }
    public String getDay() {
        return this.day;
    }
    public String getWord() {
        return this.word ;
    }
    public String getAnswer() {
        return this.answer;
    }
    public String getWrong_answer() {
        return this.wrong_answer;
    }
}

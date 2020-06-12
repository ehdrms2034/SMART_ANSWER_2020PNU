package com.example.smart_answer.recycler;

public class RecyclerTodayVoca {
    private String vocaWord;

    public RecyclerTodayVoca(String vocaWord) {
        this.vocaWord = vocaWord;
    }

    public RecyclerTodayVoca() {

    }


    public String getVocaWord() {
        return vocaWord;
    }

    public void getVocaWord(String vocaWord) {
        this.vocaWord = vocaWord;
    }
}

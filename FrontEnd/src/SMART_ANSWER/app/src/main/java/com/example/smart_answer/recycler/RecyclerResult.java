package com.example.smart_answer.recycler;

public class RecyclerResult {
    private String correct;
    private String myAnswer;

    public RecyclerResult(String correct, String myAnswer) {
        this.correct = correct;
        this.myAnswer = myAnswer;
    }

    public RecyclerResult() {

    }


    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getMyAnswer() {
        return myAnswer;
    }

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }
}

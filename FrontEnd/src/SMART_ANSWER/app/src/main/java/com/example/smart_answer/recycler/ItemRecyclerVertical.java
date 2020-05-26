package com.example.smart_answer.recycler;

public class ItemRecyclerVertical {

    private String title;
    private String date;

    public ItemRecyclerVertical(String title, String date) {
        this.title = title;
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package com.smartanswer.ocrproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserImageURL {
    private String owner;
    private String date;
    private String imageUrl;

    public UserImageURL(String owner, String date, String imageUrl){
        this.owner=owner;
        this.date=date;
        this.imageUrl=imageUrl;
    }
}

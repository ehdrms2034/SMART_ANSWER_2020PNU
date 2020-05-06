package com.smartanswer.ocrproject.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document("Answer")
public class Answer {
    @Indexed(unique = true)
    private String owner;
    private List<String> word;
    private List<String> myword;
    @Id
    private ObjectId _id;
    private String photourl;
    private int point;

    public Answer(String owner, List<String> word, List<String> myword, String photourl, int point) {
        this.owner = owner;
        this.word = word;
        this.myword= myword;
        this.photourl = photourl;
        this.point = point;
    }

}

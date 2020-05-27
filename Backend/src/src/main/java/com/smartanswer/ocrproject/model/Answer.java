package com.smartanswer.ocrproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document("Answer")
public class Answer {
    @Id
    private ObjectId _id;

    private String owner;
    private List<String> word;
    private List<String> myword;
    private String photourl;
    private int point;
    private String date;

    public Answer(String owner, List<String> word, List<String> myword, String photourl, int point, String date) {
        this.owner = owner;
        this.word = word;
        this.myword= myword;
        this.photourl = photourl;
        this.point = point;
        this.date = date;
    }
}

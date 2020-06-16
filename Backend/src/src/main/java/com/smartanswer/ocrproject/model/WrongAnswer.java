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
@Document("WrongAnswer")
public class WrongAnswer {
    @Id
    private ObjectId _id;

    private String owner;
    private String date;
    private int wrong_count; //틀린 단어 개수
    private int answer_count; //전체 단어 개수

    private List<String> correct_word;
    private List<String> mean_word;
    private List<String> my_word;

    public WrongAnswer(String owner, String date, int wrong_count, int answer_count, List<String> correct_word, List<String> mean_word, List<String> my_word) {
        this.owner = owner;
        this.date = date;
        this.wrong_count = wrong_count;
        this.answer_count = answer_count;
        this.correct_word = correct_word;
        this.mean_word = mean_word;
        this.my_word = my_word;
    }
}

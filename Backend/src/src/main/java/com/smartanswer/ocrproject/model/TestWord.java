package com.smartanswer.ocrproject.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document("TestWord")
public class TestWord {

    @Id
    ObjectId Id;

    String owner;
    String date;

    List<String> wrongWord;
    List<String> recommendWord;
    List<String> testWord;

    public TestWord(String owner, String date, List<String> wrongWord, List<String> recommendWord, List<String> testWord){
        this.owner=owner;
        this.date=date;
        this.wrongWord=wrongWord;
        this.recommendWord=recommendWord;
        this.testWord=testWord;
    }
}

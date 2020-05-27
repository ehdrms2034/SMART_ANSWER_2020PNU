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
    private List<String> wrongWord;

    public WrongAnswer(String owner, List<String> wrongWord) {
        this.owner = owner;
        this.wrongWord = wrongWord;
    }
}

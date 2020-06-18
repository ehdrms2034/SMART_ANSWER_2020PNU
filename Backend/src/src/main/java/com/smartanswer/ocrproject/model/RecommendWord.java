package com.smartanswer.ocrproject.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document("RecommendWord")
public class RecommendWord {
    @Id
    private ObjectId _id;

    private String owner;

    private List<String> recommended;

    RecommendWord(String owner, List<String> recommended){
        this.owner=owner;
        this.recommended=recommended;
    }
}

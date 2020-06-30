package com.smartanswer.ocrproject.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document("WrongAnswer")
@NoArgsConstructor
public class WrongAnswer {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;

    private String owner;
    private String date;
    private int wrong_count; //틀린 단어 개수
    private int answer_count; //전체 단어 개수
    private int level;

    private List<String> correct_word;
    private List<String> mean_word;
    private List<String> my_word;

}

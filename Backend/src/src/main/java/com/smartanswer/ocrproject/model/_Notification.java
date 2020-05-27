package com.smartanswer.ocrproject.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("Notification")
public class _Notification {
    @Id
    private ObjectId _id;

    @Indexed(unique = true)
    private int count;

    private String title;
    private String context;

    public _Notification(String title, String context){
        this.title = title;
        this.context = context;
    }

}

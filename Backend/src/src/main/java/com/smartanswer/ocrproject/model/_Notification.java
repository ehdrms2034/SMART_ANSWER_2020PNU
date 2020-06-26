package com.smartanswer.ocrproject.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.lang.reflect.Constructor;
import java.util.Date;

@Getter
@Setter
@Document("_Notification")
public class _Notification {
    @CreatedDate
    private Date date;
    // TODO: 2020-06-15 count Auto increasing Modify Issue
    private String title;
    private String context;

    public _Notification(String title, String context){
        this.title = title;
        this.context = context;
    }

}

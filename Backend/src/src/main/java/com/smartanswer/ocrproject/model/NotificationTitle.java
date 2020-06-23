package com.smartanswer.ocrproject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("NotificationTitle")
public class NotificationTitle {
    private String date;
    private String title;

    public NotificationTitle(String date, String title){
        this.date = date;
        this.title = title;
    }

}

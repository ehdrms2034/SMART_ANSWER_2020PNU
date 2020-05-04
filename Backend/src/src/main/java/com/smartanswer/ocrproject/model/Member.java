package com.smartanswer.ocrproject.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document("Member")
public class Member {
    @Indexed(unique = true)
    private String username;
    private String password;
    private String name;
    @Id
    private ObjectId _id;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date modifiedAt;

    public Member(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

}

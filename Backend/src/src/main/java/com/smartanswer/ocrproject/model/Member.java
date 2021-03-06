package com.smartanswer.ocrproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document("Member")
public class Member {
    @Indexed(unique = true)
    private String username;
    private String password;
    private String name;
    private int point;
    private int level;
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date modifiedAt;



    @DBRef(lazy = true)
    @JsonIgnore
    ArrayList<Member> friends;

    public Member(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.friends = new ArrayList<Member>();
    }

}

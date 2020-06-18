package com.smartanswer.ocrproject.model.Request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestAddFriends {
    String member1;
    String member2;
}

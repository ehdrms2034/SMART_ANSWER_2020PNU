package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.Date;


public interface AnswerService {

    Answer getPoint(String id, Date date);
}

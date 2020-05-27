package com.smartanswer.ocrproject.service.impl;

import com.smartanswer.ocrproject.model.Answer;
import com.smartanswer.ocrproject.repository.AnswerRepository;
import com.smartanswer.ocrproject.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AnswerServiceImpl implements AnswerService {

    private MongoOperations mongoOperations;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer getPoint(String id, Date date){
        return answerRepository.findByOwner(id);
    }
}
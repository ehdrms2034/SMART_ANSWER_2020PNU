package com.smartanswer.ocrproject.service.impl;

import com.smartanswer.ocrproject.model.Answer;
import com.smartanswer.ocrproject.repository.AnswerRepository;
import com.smartanswer.ocrproject.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer getAnswer(String id, String searchDate){
        return answerRepository.findOneByOwnerAndDate(id,searchDate);
    }

    @Override
    public void inputAnswer(Answer answer) {
        try {
            answerRepository.save(answer);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
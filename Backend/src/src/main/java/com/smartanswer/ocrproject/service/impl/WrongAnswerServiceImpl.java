package com.smartanswer.ocrproject.service.impl;

import com.smartanswer.ocrproject.model.WrongAnswer;
import com.smartanswer.ocrproject.repository.WrongAnswerRepository;
import com.smartanswer.ocrproject.service.WrongAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WrongAnswerServiceImpl implements WrongAnswerService {

    @Autowired
    private WrongAnswerRepository wrongAnswerRepository;

    @Override
    public List<WrongAnswer> getWrongAnswer(String id) {
        return wrongAnswerRepository.findAllByOwner(id);
    }

    @Override
    public boolean inputWrongAnswer(WrongAnswer wrongAnswer) {
        try {
            wrongAnswerRepository.save(wrongAnswer);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // TODO: 2020-05-26
//    @Override
//    public boolean updateWrongAnswer(WrongAnswer wrongAnswer) {
//        try {
//            wrongAnswerRepository.save(wrongAnswer);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}

package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.WrongAnswer;

import java.util.List;

public interface WrongAnswerService {
    List<WrongAnswer> getWrongAnswer(String id);

//    boolean updateWrongAnswer(WrongAnswer wrongAnswer);

    boolean inputWrongAnswer(WrongAnswer wrongAnswer);
}


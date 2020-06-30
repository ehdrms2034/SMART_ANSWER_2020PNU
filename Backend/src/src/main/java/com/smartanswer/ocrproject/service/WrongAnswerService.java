package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.WrongAnswer;

import java.util.List;

public interface WrongAnswerService {
    WrongAnswer getWrongAnswer(String owner, String date);

//    boolean updateWrongAnswer(WrongAnswer wrongAnswer);
    List<WrongAnswer> getAllWrongAnswer(String owner);
    boolean inputWrongAnswer(WrongAnswer wrongAnswer);
}


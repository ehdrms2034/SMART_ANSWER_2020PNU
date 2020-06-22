package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.WrongAnswer;

import java.util.List;

public interface WrongAnswerService {
    WrongAnswer getWrongAnswer(String owner, String date);

//    boolean updateWrongAnswer(WrongAnswer wrongAnswer);

    boolean inputWrongAnswer(WrongAnswer wrongAnswer);
}


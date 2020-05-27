package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.Answer;


public interface AnswerService {

    Answer getAnswer(String id, String date);

    void inputAnswer(Answer answer);
}

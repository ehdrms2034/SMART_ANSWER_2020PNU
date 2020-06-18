package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.RecommendWord;

public interface RecommendService {
    boolean inputRecommendWord(String owner, RecommendWord recommendWord);

    RecommendWord getByUserID(String owner);
}

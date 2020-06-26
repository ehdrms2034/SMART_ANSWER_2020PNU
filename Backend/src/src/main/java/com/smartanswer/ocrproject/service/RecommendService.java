package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.RecommendWord;

public interface RecommendService {
    boolean inputRecommendWord(RecommendWord recommendWord);

    RecommendWord getByUserID(String owner);
}

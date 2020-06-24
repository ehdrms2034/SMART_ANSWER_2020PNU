package com.smartanswer.ocrproject.service.impl;

import com.smartanswer.ocrproject.model.RecommendWord;
import com.smartanswer.ocrproject.repository.RecommendWordRepository;
import com.smartanswer.ocrproject.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendWordRepository recommendWordRepository;

    // TODO: 2020-06-15 (recommend word updating function) modifying issue
    @Override
    public boolean inputRecommendWord(RecommendWord recommendWord) {

        try {
            recommendWordRepository.save(recommendWord);
            return true;
        } catch (Exception E){
            E.printStackTrace();
            return false;
        }
    }

    @Override
    public RecommendWord getByUserID(String owner) {
        return recommendWordRepository.findByOwner(owner);
    }
}

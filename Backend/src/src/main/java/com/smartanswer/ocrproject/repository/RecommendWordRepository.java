package com.smartanswer.ocrproject.repository;

import com.smartanswer.ocrproject.model.RecommendWord;
import com.smartanswer.ocrproject.model.WrongAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendWordRepository extends MongoRepository<RecommendWord, Long> {
    RecommendWord findByOwner(String owner);
}

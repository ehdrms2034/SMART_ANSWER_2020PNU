package com.smartanswer.ocrproject.repository;

import com.smartanswer.ocrproject.model.TestWord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestWordRepository extends MongoRepository<TestWord, Long> {
    TestWord findByOwnerAndDate(String owner, String date);
}

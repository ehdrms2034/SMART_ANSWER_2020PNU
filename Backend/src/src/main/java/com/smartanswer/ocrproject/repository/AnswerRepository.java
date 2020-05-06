package com.smartanswer.ocrproject.repository;

import com.smartanswer.ocrproject.model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends MongoRepository<Answer,Long> {

}


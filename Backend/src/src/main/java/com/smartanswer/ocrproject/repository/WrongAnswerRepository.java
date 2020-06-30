package com.smartanswer.ocrproject.repository;

import com.smartanswer.ocrproject.model.WrongAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrongAnswerRepository extends MongoRepository<WrongAnswer,Long> {
    WrongAnswer findByOwnerAndDate(String owner, String date);
    List<WrongAnswer> findAllByOwner(String owner);
}

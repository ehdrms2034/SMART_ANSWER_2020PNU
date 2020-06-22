package com.smartanswer.ocrproject.repository;

import com.smartanswer.ocrproject.model.UserImageURL;
import com.smartanswer.ocrproject.model.WrongAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserImageRepository extends MongoRepository<UserImageURL,Long> {
    UserImageURL findByOwnerAndDate(String owner, String date);
}

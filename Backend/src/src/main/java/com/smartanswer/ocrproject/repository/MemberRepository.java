package com.smartanswer.ocrproject.repository;

import com.smartanswer.ocrproject.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<Member,Long> {
    Member findOneByUsername(String username);
}
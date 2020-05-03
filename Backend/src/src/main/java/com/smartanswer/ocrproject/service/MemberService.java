package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MemberService {

    List<Member> findAllMembers();

    void createMember(Member member);
}
package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.Member;

import java.util.List;


public interface MemberService {

    List<Member> findAllMembers();

    void createMember(Member member);

    Member findOneByUsername(String username);

    Member login(String username, String password) throws Exception;
}
package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.Member;

import java.util.List;


public interface MemberService {

    List<Member> findAllMembers();

    void createMember(Member member);

    Member findOneByUsername(String username) throws Exception;

    Member login(String username, String password) throws Exception;

    void addFriend(Member member, Member friend) throws Exception;

    List<Member> getFriendsList(Member member) throws Exception;

    boolean isInFriendsList(Member member1, Member member2) throws Exception;
}
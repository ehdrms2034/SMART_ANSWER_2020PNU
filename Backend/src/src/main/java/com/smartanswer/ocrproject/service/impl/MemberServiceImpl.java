package com.smartanswer.ocrproject.service.impl;

import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.repository.MemberRepository;
import com.smartanswer.ocrproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private MongoOperations mongoOperations;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void createMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findOneByUsername(String username) {
        return memberRepository.findOneByUsername(username);
    }
}

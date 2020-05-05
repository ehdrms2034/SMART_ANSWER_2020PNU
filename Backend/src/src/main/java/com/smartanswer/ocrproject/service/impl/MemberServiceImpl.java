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

    @Override
    public Member login(String username, String password) throws Exception {
        Member member = memberRepository.findOneByUsername(username);
        if (member == null) throw new Exception("MemberServiceImpl : 선택한 유저를 찾을 수가 없습니다.");
        if (!member.getPassword().equals(password)) throw new Exception("MemberServiceImpl : 유저의 비밀번호가 틀렸습니다.");
        return member;
    }
}

package com.smartanswer.ocrproject.service.impl;

import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.repository.MemberRepository;
import com.smartanswer.ocrproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public Member findOneByUsername(String username) throws Exception{
        Member member = memberRepository.findOneByUsername(username);
        if(member== null) throw new Exception("MemberServiceImpl : 선택한 유저를 찾을 수가 없습니다.");
        return member;
    }

    @Override
    public Member login(String username, String password) throws Exception {
        Member member = memberRepository.findOneByUsername(username);
        if (member == null) throw new Exception("MemberServiceImpl : 선택한 유저를 찾을 수가 없습니다.");
        if (!member.getPassword().equals(password)) throw new Exception("MemberServiceImpl : 유저의 비밀번호가 틀렸습니다.");
        return member;
    }

    @Override
    public void addFriend(Member member, Member newFriend) throws Exception {
        if (member == null || newFriend == null)
            throw new Exception("MemberServiceImpl , addFriend : 선택한 유저를 찾을 수가 없습니다.");
        ArrayList<Member> memberFriends = member.getFriends();
        ArrayList<Member> friendsFriends = newFriend.getFriends();

        if (isInFriendsList(member, newFriend) || isInFriendsList(newFriend, member))
            throw new Exception("MemberServiceImpl , addFriend : 선택한 멤버가 이미 친구 리스트에 존재합니다.");

        memberFriends.add(newFriend);
        friendsFriends.add(member);

        member.setFriends(memberFriends);
        newFriend.setFriends(friendsFriends);

        memberRepository.save(member);
        memberRepository.save(newFriend);
    }

    @Override
    public List<Member> getFriendsList(Member member) throws Exception {
        if (member == null) throw new Exception("MemberServiceImpl, getFriendsList : 선택한 유저를 찾을 수 없습니다.");
        return member.getFriends();
    }

    @Override
    public boolean isInFriendsList(Member member1, Member member2) throws Exception {
        if (member1 == null || member2 == null)
            throw new Exception("MemberServiceImpl, isInFriendsList : 선택한 유저를 찾을 수 없습니다.");
        for (Member friend : member1.getFriends()) {
            if (friend.get_id().equals(member2.get_id()))
                return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void addPoint(Member member, int point) throws Exception {
        if(member == null)
            throw new Exception("MemberServiceImpl, addPoint : 선택한 유저를 찾을 수 없습니다.");
        int level = member.getLevel();
        int parsedPoint = member.getPoint() + point;
        if(level<5 &&parsedPoint>=100){
            level++;
            parsedPoint-=100;
        }
        member.setLevel(level);
        member.setPoint(parsedPoint);
        memberRepository.save(member);
    }

    @Override
    public int getLevel(Member member) throws Exception {
        if(member == null)
            throw new Exception("MemberServiceImpl, getLevel : 선택한 유저를 찾을 수 없습니다.");
        return member.getLevel();
    }

}

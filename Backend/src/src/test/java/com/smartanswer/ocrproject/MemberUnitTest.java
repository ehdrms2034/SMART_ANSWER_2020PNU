package com.smartanswer.ocrproject;

import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MemberUnitTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void scenario(){
        createMember("test");
        createMember("test1");
        createMember("test2");
    }

    @Test
    public void createMember(String uname){
        String username = uname;
        String password = "1234";
        String name = "김동근";
        memberService.createMember(new Member(username,password,name));
    }

    @Test
    public void addFriends(){
        Member member1 = memberService.findOneByUsername("test");
        Member member2 = memberService.findOneByUsername("test2");
        try {
            memberService.addFriend(member1,member2);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Test
    public void getFriendsList(){
        Member member = memberService.findOneByUsername("test");
        for(Member friend : member.getFriends())
            System.out.println(friend.getUsername());
    }


}

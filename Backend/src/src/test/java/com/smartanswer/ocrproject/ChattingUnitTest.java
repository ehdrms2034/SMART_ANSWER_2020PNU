package com.smartanswer.ocrproject;

import com.smartanswer.ocrproject.model.ChattingRoom;
import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.service.ChattingService;
import com.smartanswer.ocrproject.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ChatRoomUnitTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ChattingService chattingService;

    @Test
    void test(){
        System.out.print("Hello");
    }

    @Test
    void createChatRoom(){
        Member member1 = memberService.findOneByUsername("test");
        Member member2 = memberService.findOneByUsername("test2");
        try {
            chattingService.makeChattingRoom(member1,member2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getChatRoomList(){
        Member member = memberService.findOneByUsername("test");
        List<ChattingRoom> chatRooms = null;
        try {
            chatRooms = chattingService.getChattingRoomList(member);
            System.out.println("와하우:" + chatRooms.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.ChatMessage;
import com.smartanswer.ocrproject.model.ChattingRoom;
import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.service.ChattingService;
import com.smartanswer.ocrproject.service.MemberService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChattingController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ChattingService chattingService;

    @PostMapping("/room")
    public CustomResponse createChatRoom(@RequestBody String username1, @RequestBody String username2) {
        try {
            Member member = memberService.findOneByUsername(username1);
            Member member2 = memberService.findOneByUsername(username2);
            chattingService.makeChattingRoom(member,member2);
            return new CustomResponse("success","성공적으로 채팅방을 생성했습니다.",null);
        } catch (Exception e) {
            return new CustomResponse("error","채팅방 생성을 실패했습니다.",e.getMessage());
        }
    }
    @GetMapping("/rooms")
    public CustomResponse getChatRooms(@RequestParam("username") String username){
        try{
            Member member = memberService.findOneByUsername(username);
            List<ChattingRoom> chattingRooms=chattingService.getChattingRoomList(member);
            return new CustomResponse("success","성공적으로 채팅방 목록을 불러왔습니다.",chattingRooms);
        }catch(Exception e){
            return new CustomResponse("error","채팅방 목록을 불러오는데 실패했습니다.",e.getMessage());
        }
    }

    @PostMapping("/message")
    public CustomResponse createChatMessage(@RequestBody String chatRoomId, @RequestBody String username,@RequestBody String message){
        try{
            ChattingRoom chattingRoom = chattingService.getChattingRoomById(chatRoomId);
            Member member = memberService.findOneByUsername(username);
            chattingService.makeChattingMessage(chattingRoom,member,message);
            return new CustomResponse("success","성공적으로 채팅방 메시지를 저장했습니다.",null);
        }catch(Exception e){
            return new CustomResponse("error","채팅방 메시지를 생성하는데 실패했습니다.",null);
        }
    }

    @GetMapping("/messages")
    public CustomResponse getChatMessages(@RequestParam String chatRoomId){
        try{
            ChattingRoom chattingRoom = chattingService.getChattingRoomById(chatRoomId);
            List<ChatMessage> messages = chattingService.getChattingMessages(chattingRoom);
            return new CustomResponse("success","성공적으로 채팅메시지를 불러왔습니다.",messages);
        }catch(Exception e){
            return new CustomResponse("error","채팅 메시지를 가져오는데 실패했습니다",e.getMessage());
        }
    }

}
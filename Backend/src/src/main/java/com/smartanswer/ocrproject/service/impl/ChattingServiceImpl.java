package com.smartanswer.ocrproject.service.impl;

import com.smartanswer.ocrproject.model.ChatMessage;
import com.smartanswer.ocrproject.model.ChattingRoom;
import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.repository.ChattingMessageRepository;
import com.smartanswer.ocrproject.repository.ChattingRoomRepository;
import com.smartanswer.ocrproject.service.ChattingService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChattingServiceImpl implements ChattingService {

    private MongoOperations mongoOperations;

    @Autowired
    private ChattingRoomRepository chattingRoomRepository;

    @Autowired
    private ChattingMessageRepository chattingMessageRepository;

    @Override
    public void makeChattingRoom(Member member, Member member2) throws Exception {
        if (member == null || member2 == null)
            throw new Exception("ChattingRoomServiceImpl,makeChattingRoom : member가 조회되지 않음.");
        ArrayList<Member> members = new ArrayList<>();
        members.add(member);
        members.add(member2);
        ChattingRoom newChatRoom = new ChattingRoom(members);
        chattingRoomRepository.save(newChatRoom);
    }

    @Override
    public void makeChattingMessage(ChattingRoom chatRoom, Member member, String message) throws Exception {
        if(chatRoom == null) throw new Exception("ChattingRoomServiceImpl, makeChattingMessage : chatRoom이 조회되지 않음.");
        if(member == null) throw new Exception("ChattingRoomServiceImpl,makeChattingMessage : member가 조회되지 않음.");
        if(message == null) throw new Exception("ChattingRoomServiceImpl,makeChattingMessage : message가 조회되지 않음.");

        ChatMessage newMessage = new ChatMessage(chatRoom,member,message);
        chattingMessageRepository.save(newMessage);
    }

    @Override
    public ChattingRoom getChattingRoomById(String chatRoomId) throws Exception{
        if(chatRoomId==null) throw new Exception("ChattingRoomServiceImpl, makeChattingMessage : chatRoom이 조회되지 않음.");
        ChattingRoom chatRoom = chattingRoomRepository.findBy_id(new ObjectId(chatRoomId));
        if(chatRoom==null) throw new Exception("ChattingRoomServiceImpl, makeChattingMessage : chatRoom이 조회되지 않음.");
        return chatRoom;
    }

    @Override
    public List<ChattingRoom> getChattingRoomList(Member member) throws Exception {
        if (member == null) throw new Exception("ChattingRoomServiceImpl,getChattingList : member 조회되지 않음");
        return chattingRoomRepository.findByMembers(member);
    }

    @Override
    public List<ChatMessage> getChattingMessages(ChattingRoom chattingRoom) throws  Exception{
        if(chattingRoom == null) throw new Exception("ChattingRoomServiceImpl,getChattingList : member 조회되지 않음");
        return chattingMessageRepository.findByChattingRoom(chattingRoom);
    }

}

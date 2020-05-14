package com.smartanswer.ocrproject.service.impl;

import com.smartanswer.ocrproject.model.ChattingRoom;
import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.repository.ChattingRoomRepository;
import com.smartanswer.ocrproject.service.ChattingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChattingRoomServiceImpl implements ChattingRoomService {

    private MongoOperations mongoOperations;

    @Autowired
    private ChattingRoomRepository chattingRoomRepository;

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
    public List<ChattingRoom> getChattingRoomList(Member member) throws Exception {
        if (member == null) throw new Exception("ChattingRoomServiceImpl,getChattingList : member 조회되지 않음");
        return chattingRoomRepository.findByMembers(member);
    }

}

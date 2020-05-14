package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.ChatMessage;
import com.smartanswer.ocrproject.model.ChattingRoom;
import com.smartanswer.ocrproject.model.Member;

import java.util.List;

public interface ChattingService {

    public void makeChattingRoom(Member member,Member member2) throws Exception;

    public void makeChattingMessage(ChattingRoom chatRoom, Member member, String message) throws Exception;

    public List<ChattingRoom> getChattingRoomList(Member member) throws Exception;

    List<ChatMessage> getChattingMessages(ChattingRoom chattingRoom) throws  Exception;
}
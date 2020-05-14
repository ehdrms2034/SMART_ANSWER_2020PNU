package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.ChattingRoom;
import com.smartanswer.ocrproject.model.Member;

import java.util.List;

public interface ChattingRoomService {

    public void makeChattingRoom(Member member,Member member2) throws Exception;

    public List<ChattingRoom> getChattingRoomList(Member member) throws Exception;

}
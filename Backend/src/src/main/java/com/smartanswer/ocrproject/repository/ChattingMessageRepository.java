package com.smartanswer.ocrproject.repository;

import com.smartanswer.ocrproject.model.ChatMessage;
import com.smartanswer.ocrproject.model.ChattingRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChattingMessageRepository extends MongoRepository<ChatMessage,Long> {

    List<ChatMessage> findByChattingRoom(ChattingRoom chattingRoom);
}

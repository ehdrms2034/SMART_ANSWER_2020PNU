package com.smartanswer.ocrproject.repository;

import com.smartanswer.ocrproject.model.ChattingRoom;
import com.smartanswer.ocrproject.model.Member;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChattingRoomRepository extends MongoRepository<ChattingRoom,Long> {

    List<ChattingRoom> findByMembers(Member member);

    ChattingRoom findBy_id(ObjectId objectId);
}
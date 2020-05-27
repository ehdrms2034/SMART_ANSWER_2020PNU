package com.smartanswer.ocrproject.repository;

import com.smartanswer.ocrproject.model._Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<_Notification,Long> {

}

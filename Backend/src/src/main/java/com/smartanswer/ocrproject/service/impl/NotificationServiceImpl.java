package com.smartanswer.ocrproject.service.impl;

import com.smartanswer.ocrproject.model._Notification;
import com.smartanswer.ocrproject.repository.NotificationRepository;
import com.smartanswer.ocrproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    //Notification(공지사항) 출력하는 함수 : 모두를 리스트로 반납한다
    @Override
    public List<_Notification> getAllNotification() {
        return notificationRepository.findAll();
    }

    @Override
    public boolean inputNotification(_Notification notification) {
        try{
            notificationRepository.save(notification);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

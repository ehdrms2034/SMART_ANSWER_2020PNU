package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.Answer;
import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.model.RequestGetAnswer;
import com.smartanswer.ocrproject.model._Notification;
import com.smartanswer.ocrproject.service.AnswerService;
import com.smartanswer.ocrproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/notify")
@RestController
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    //notification들을 list로 반환해주는 함수
    @PostMapping("/getNotification")
    CustomResponse getNotification(@RequestBody RequestGetAnswer request){
        List<_Notification> notification = notificationService.getAllNotification();
        if(notification.isEmpty()) {
            return new CustomResponse("fail", "공지사항이 존재하지 않습니다", "공지사항이 존재하지 않습니다");
        } else {
            return new CustomResponse("success","공지사항 조회 결과 입니다",notification);
        }
    }
}

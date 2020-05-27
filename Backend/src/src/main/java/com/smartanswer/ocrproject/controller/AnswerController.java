package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.Answer;
import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.model.RequestGetAnswer;
import com.smartanswer.ocrproject.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/answer")
@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;


    @PostMapping("/getAnswerInfo")
    CustomResponse getAnswerByDate(@RequestBody RequestGetAnswer request){
       Answer answer = answerService.getAnswer(request.getId(),request.getDate());
       if(answer.get_id()==null){
           return new CustomResponse("fail","존재하지 않는 사용자입니다.",null);
       } else if(answer.getDate()==null){
           return new CustomResponse("fail","해당 날짜에 사용자의 기록이 없습니다.",null);
       } else {
           return new CustomResponse("success",request.getDate() + " : 조회 결과 입니다",answer);
       }
    }

    @PostMapping("/inputAnswer")
    CustomResponse inputAnswer(@RequestBody Answer answer){
        try{
            answerService.inputAnswer(answer);
            return new CustomResponse("success","결과를 입력하였습니다.",null);
        } catch (Exception e){
            return new CustomResponse("fail","오류가 발생했습니다",e);
        }

    }


}

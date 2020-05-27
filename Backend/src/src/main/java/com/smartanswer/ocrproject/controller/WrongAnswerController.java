package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.model.WrongAnswer;
import com.smartanswer.ocrproject.model.userID;
import com.smartanswer.ocrproject.service.WrongAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/wrong")
@RestController
public class WrongAnswerController {

    @Autowired
    private WrongAnswerService wrongAnswerService;

    //해당 유저의 누적 정답을 출력해줌
    @PostMapping("/getbyid")
    CustomResponse wrongAnswer(@RequestBody userID id){
        List<WrongAnswer> wrong = wrongAnswerService.getWrongAnswer(id.getId());
        if(wrong==null){
            return new CustomResponse("fail","해당 정보가 없습니다.",null);
        }
            return new CustomResponse("success","조회 결과를 불러옵니다.",wrong);
    }

    //해당 유저의 그날 성적을 입력함
    @PostMapping("/inputWrongAnswer")
    CustomResponse inputWrongAnswer(@RequestBody WrongAnswer wrongAnswer){
        wrongAnswerService.inputWrongAnswer(wrongAnswer);
        return new CustomResponse("success","wrongAnswer 입력 성공",null);
    }
}
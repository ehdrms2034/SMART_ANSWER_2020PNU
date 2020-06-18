package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.model.WrongAnswer;
import com.smartanswer.ocrproject.model.userIDAndDate;
import com.smartanswer.ocrproject.service.WrongAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/wrong")
@RestController
public class WrongAnswerController {

    @Autowired
    private WrongAnswerService wrongAnswerService;

    //해당 유저의 누적 틀린 정답을 출력해줌
    @PostMapping("/getbyidanddate")
    CustomResponse wrongAnswer(@RequestBody userIDAndDate id){
        WrongAnswer wrong = wrongAnswerService.getWrongAnswer(id.getId(), id.getDate());
        return new CustomResponse("success","조회 결과를 불러옵니다.",wrong);
    }

    //해당 유저의 그날 성적을 입력함
    @PostMapping("/inputWrongAnswer")
    CustomResponse inputWrongAnswer(@RequestBody WrongAnswer wrongAnswer){
        wrongAnswerService.inputWrongAnswer(wrongAnswer);
        return new CustomResponse("success","wrongAnswer 입력 성공",null);
    }
}
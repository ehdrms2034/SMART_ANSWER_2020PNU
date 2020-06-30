package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.*;
import com.smartanswer.ocrproject.service.MemberService;
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

    @Autowired
    private MemberService memberService;

    //해당 유저의 누적 틀린 정답을 출력해줌
    @PostMapping("/getbyidanddate")
    CustomResponse wrongAnswer(@RequestBody UserAndDate id){
        WrongAnswer wrong = wrongAnswerService.getWrongAnswer(id.getId(), id.getDate());
        return new CustomResponse("success","조회 결과를 불러옵니다.",wrong);
    }

    //해당 유저의 그날 성적을 입력함
    @PostMapping("/inputWrongAnswer")
    CustomResponse inputWrongAnswer(@RequestBody WrongAnswer wrongAnswer){
        try {
            Member member = memberService.findOneByUsername(wrongAnswer.getOwner());
            wrongAnswerService.inputWrongAnswer(wrongAnswer);
            memberService.addPoint(member,wrongAnswer.getAnswer_count());
            return new CustomResponse("success","wrongAnswer 입력 성공",null);
        } catch (Exception e) {
            return new CustomResponse("error","wrongAnswer 입력 실패",e.getMessage());
        }

    }

    @PostMapping("/getAllInfo")
    CustomResponse allWrongAnswer(@RequestBody UserID userID){
        List<WrongAnswer> wrong = wrongAnswerService.getAllWrongAnswer(userID.getID());
        return new CustomResponse("success","조회 결과(모든 정보)를 불러옵니다.",wrong);
    }

}
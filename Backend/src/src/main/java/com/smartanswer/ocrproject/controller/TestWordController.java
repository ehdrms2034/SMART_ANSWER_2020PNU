package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.model.TestWord;
import com.smartanswer.ocrproject.model.UserAndDate;
import com.smartanswer.ocrproject.service.TestWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/test")
@RestController
public class TestWordController {

    @Autowired
    private TestWordService testWordService;

    //프론트에서 가져갈 오늘 시험칠 단어
    @PostMapping("/getTestWord")
    CustomResponse getTestWord(@RequestBody UserAndDate userAndDate){
        TestWord testWord = testWordService.getTestWord(userAndDate);
        if(testWord==null) {
            return new CustomResponse("fail", "시험칠 단어가 존재하지 않습니다.", "시험칠 단어가 존재하지 않습니다");
        } else {
            return new CustomResponse("success","시험칠 단어 조회 결과 입니다.",testWord);
        }
    }

    //머신러닝에서 오늘 시험칠 단어를 넣는 역할
    @PostMapping("/inputTestWord")
    CustomResponse inputTestWord(@RequestBody TestWord testWord){
        if(testWordService.inputTestWord(testWord)){
            return new CustomResponse("success","오늘 시험칠 단어를 입력했습니다.",null);
        } else {
            return new CustomResponse("fail","입력에 실패 했습니다.",null);
        }



    }
}


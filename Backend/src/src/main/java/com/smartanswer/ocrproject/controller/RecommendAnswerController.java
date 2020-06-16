package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.model.RecommendWord;
import com.smartanswer.ocrproject.model.UserID;
import com.smartanswer.ocrproject.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/recommend")
@RestController
public class RecommendAnswerController {

    @Autowired
    private RecommendService recommendService;

    @PostMapping("/getRecommendWord")
    CustomResponse getRecommendWord(@RequestBody UserID userID){
        RecommendWord recommendWord = recommendService.getByUserID(userID.getID());
        if(recommendWord==null){
            return new CustomResponse("fail","해당 사용자가 없습니다.",null);
        } else if(recommendWord.getRecommended()==null){
            return new CustomResponse("fail","추천 단어가 없습니다.",null);
        } else {
            return new CustomResponse("success",recommendWord.getRecommended() + " : 조회 결과 입니다",recommendWord);
        }
    }

    @PostMapping("/inputRecommendWord")
    CustomResponse inputRecommendWord(@RequestBody UserID userID, RecommendWord recommendWord){
        try{
            recommendService.inputRecommendWord(userID.getID(), recommendWord);
            return new CustomResponse("success","결과를 입력하였습니다.",null);
        } catch (Exception e){
            return new CustomResponse("fail","오류가 발생했습니다",e);
        }
    }

}

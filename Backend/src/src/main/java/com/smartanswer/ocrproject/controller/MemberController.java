package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/createMember")
    CustomResponse createMember(@RequestBody Member member){
        try{
            memberService.createMember(member);
            return new CustomResponse("success","회원가입이 성공적으로 완료됐습니다.",member);
        }catch(Exception e){
            return new CustomResponse("error","회원가입중 문제가 발생했습니다.",e.getMessage());
        }
    }

    @PostMapping("/loginMember")
    CustomResponse loginMember(@RequestBody Member member){
        return new CustomResponse("","",null);
    }

}

package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.model.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @GetMapping("/createMember")
    CustomResponse createMember(@RequestBody Member member){
        System.out.println("하이");

        return new CustomResponse("success","회원가입이 성공적으로 완료됐습니다.",member);

    }

}

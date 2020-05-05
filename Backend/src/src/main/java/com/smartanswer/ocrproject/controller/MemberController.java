package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.service.CookieUtil;
import com.smartanswer.ocrproject.service.JwtUtil;
import com.smartanswer.ocrproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    CookieUtil cookieUtil;

    @Autowired
    JwtUtil jwtUtil;

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
    CustomResponse loginMember(@RequestBody Member member, HttpServletRequest request, HttpServletResponse response){
        try {
            Member loginMember = memberService.login(member.getUsername(),member.getPassword());
            String jwtToken = jwtUtil.generateToken(loginMember);
            Cookie accessToken = cookieUtil.createCookie("accessToken",jwtToken);
            response.addCookie(accessToken);
            return new CustomResponse("success","로그인을 성공적으로 수행했습니다.",null);
        } catch (Exception e) {
            return new CustomResponse("error","로그인 중 오류가 발생했습니다.",e);
        }
    }

}

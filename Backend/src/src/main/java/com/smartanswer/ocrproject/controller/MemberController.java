package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.model.Request.RequestLogin;
import com.smartanswer.ocrproject.model.Request.RequestSignUp;
import com.smartanswer.ocrproject.service.CookieUtil;
import com.smartanswer.ocrproject.service.JwtUtil;
import com.smartanswer.ocrproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
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

    //회원가입
    @PostMapping("/createMember")
    CustomResponse createMember(@RequestBody RequestSignUp member) {
        try {
            memberService.createMember(new Member(member.getUsername(), member.getPassword(), member.getName()));
            return new CustomResponse("success", "회원가입이 성공적으로 완료됐습니다.", member);
        } catch (Exception e) {
            return new CustomResponse("error", "회원가입중 문제가 발생했습니다.", e.getMessage());
        }
    }

    @PostMapping("/loginMember")
    CustomResponse loginMember(@RequestBody RequestLogin member, HttpServletRequest request, HttpServletResponse response) {
        try {
            Member loginMember = memberService.login(member.getUsername(), member.getPassword());
            String jwtToken = jwtUtil.generateToken(loginMember);
            Cookie accessToken = cookieUtil.createCookie("accessToken", jwtToken);
            response.addCookie(accessToken);
            return new CustomResponse("success", "로그인을 성공적으로 수행했습니다.", null);
        } catch (Exception e) {
            return new CustomResponse("error", "로그인 중 오류가 발생했습니다.", e.getMessage());
        }
    }

    @GetMapping("/")
    public CustomResponse getMember(@RequestParam("username") String username) {
        try {
            Member member = memberService.findOneByUsername(username);
            return new CustomResponse("success", "성공적으로 유저를 불러왔습니다..", member);
        } catch (Exception e) {
            return new CustomResponse("error", "유저를 불러오는 실패했습니다.", e.getMessage());
        }
    }

    @GetMapping("/friends")
    CustomResponse getFriends(@RequestParam("username") String username) {
        try {
            Member member = memberService.findOneByUsername(username);
            return new CustomResponse("success", "성공적으로 친구 목록을 불러왔습니다.", memberService.getFriendsList(member));
        } catch (Exception e) {
            return new CustomResponse("error", "친구 목록을 불러오는데 실패했습니다", e.getMessage());
        }
    }

    @PostMapping("/addFriend")
    CustomResponse addFriends(@RequestBody String username1, @RequestBody String username2) {
        try {
            Member member1 = memberService.findOneByUsername(username1);
            Member member2 = memberService.findOneByUsername(username2);
            memberService.addFriend(member1, member2);
            return new CustomResponse("success", "성공적으로 친구를 저장했습니다.", null);
        } catch (Exception e) {
            return new CustomResponse("error", "친구를 저장하는데 실패했습니다.", e.getMessage());
        }
    }



}

package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.model.SecurityMember;
import com.smartanswer.ocrproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException {

        Member member = memberRepository.findOneByUsername(username);
        if(member==null){
            throw new UsernameNotFoundException( username+ " : 사용자 존재하지 않음");
        }
        return new SecurityMember(member);
    }

}

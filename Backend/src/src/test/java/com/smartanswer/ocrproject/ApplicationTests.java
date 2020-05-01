package com.smartanswer.ocrproject;

import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

	@Autowired
	private MemberService memberService;

	@Test
	void contextLoads() {
		memberService.createMember(new Member("hellos","username","hello"));
	}

}

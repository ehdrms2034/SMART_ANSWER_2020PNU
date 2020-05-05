package com.smartanswer.ocrproject;

import com.smartanswer.ocrproject.model.Member;
import com.smartanswer.ocrproject.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.config.location=classpath:application-test.properties"})
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private MemberService memberService;

	@Test
	void contextLoads() {
		System.out.println(memberService.findOneByUsername("hellos").getPassword());
	}

	@Test
	void createUser() throws Exception {
		mockMvc.perform(get("/api/member/createMember"))
				.andExpect(status().isOk())
				.andDo(print());
	}

}

package com.smartanswer.ocrproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartanswer.ocrproject.model.Member;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class MockTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    void createMember() throws Exception {
        Member member = new Member("myNameIs2", "kim", "donggeun");
        mockMvc.perform(post("/api/member/createMember")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(member))
        )
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void loginMember() throws Exception {
        Member member = new Member("myNameIs2", "kim", "donggeun");
        mockMvc.perform(post("/api/member/loginMember")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(member)))
                .andExpect(status().isOk())
                .andDo(print());
    }

}

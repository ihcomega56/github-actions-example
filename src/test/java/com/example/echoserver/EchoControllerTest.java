package com.example.echoserver;

import com.example.echoserver.controller.EchoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EchoController.class)
public class EchoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void returnStatus200() throws Exception {
        this.mockMvc.perform(post("/echo")
                .content("hello")
                .contentType(MediaType.TEXT_PLAIN)
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk());
    }

    @Test
    void returnRequestedText() throws Exception {
        this.mockMvc.perform(post("/echo")
                .content("hello")
                .contentType(MediaType.TEXT_PLAIN)
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(content().string(matchesPattern("hello")));
    }
}


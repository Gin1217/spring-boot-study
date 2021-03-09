package com.example.springbootbasic.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)

class BookControllerTest {

    @Resource
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

//    private static MockMvc mockMvc;

//    @BeforeAll
//    static void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new BookController()).build();
//    }

    @Test
    void saveBook() throws Exception {
       String book = "{\n" +
                "  \"id\": 1,\n" +
                "  \"author\": \"Gin\",\n" +
                "  \"title\": \"Spring Boot 从入门到放弃\",\n" +
                "  \"content\": \"Spring Boot 从入门到放弃\",\n" +
                "  \"createTime\": \"2021-3-8 19:04:23\",\n" +
                "  \"readers\":[{\"name\": \"aaa\",\"age\": 21},{\"name\": \"bbb\",\"age\": 20}]\n" +
                "}";

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST,"/api/v1/books")
                        .contentType("application/json")
                        .content(book)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("Gin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[0].age").value(21))
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }

}

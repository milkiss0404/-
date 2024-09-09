//package com.example.springbootdev.controller;
//
//import com.example.springbootdev.domain.Article;
//import com.example.springbootdev.dto.AddArticleRequest;
//import com.example.springbootdev.repository.BlogRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@SpringBootTest
//@AutoConfigureMockMvc
//class BlogApiControllerTest {
//
//    @Autowired
//    protected MockMvc mockMvc;
//
//    @Autowired
//    protected ObjectMapper objectMapper; //직렬화 역직렬화를 위한 클래스
//
//    @Autowired
//    private WebApplicationContext context;
//    @Autowired
//    BlogRepository blogRepository;
//
//    @BeforeEach
//    public void mockMvcSetUp(){
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
//                .build();
//        blogRepository.deleteAll();
//    }  //직렬화  == 객체 -> json
//        //역직렬화 == json -> 객체
//
//
//    @Test
//    @DisplayName("addArticle: 블로그 글 추가에 성공한다.")
//    public void addArticle () throws Exception{
//        //given
//        final String url = "/api/articles";
//        final String title = "title";
//        final String content = "content";
//        final AddArticleRequest userRequest = new AddArticleRequest(title, content);
//        final String requestBody = objectMapper.writeValueAsString(userRequest);
//        //when
//        ResultActions result = mockMvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(requestBody));
//        //then
//        result.andExpect(status().isCreated());
//
//        List<Article> articles = blogRepository.findAll();
//
//        Assertions.assertThat(articles.size()).isEqualTo(1);
//        Assertions.assertThat(articles.get(0).getTitle()).isEqualTo(title);
//        Assertions.assertThat(articles.get(0).getContent()).isEqualTo(content);
//
//
//    }
//
//}
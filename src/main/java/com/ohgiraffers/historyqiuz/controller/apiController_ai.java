package com.ohgiraffers.historyqiuz.controller;

import com.ohgiraffers.historyqiuz.dto.QuizDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class apiController_ai {

    @Autowired
    private RestTemplate restTemplate;

    public QuizDTO sendGetRequest() {
        String url = "http://192.168.1.75:8000/create_q";
        url = "http://localhost:8080/test/single";
        QuizDTO response = restTemplate.getForObject(url, QuizDTO.class);
        System.out.println(response);
        return response;
    }

}

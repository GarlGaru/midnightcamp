package com.ohgiraffers.historyqiuz;

import com.ohgiraffers.historyqiuz.controller.ApiController;
import com.ohgiraffers.historyqiuz.controller.apiController_ai;
import com.ohgiraffers.historyqiuz.dto.QuizDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class apiController_aiTest {

    @Autowired
    private apiController_ai aiApiController;

    @Autowired
    private ApiController apiController;

    @DisplayName("get요청 보내기")
    @Test
    public void getRequestSendingTest(){

        Assertions.assertDoesNotThrow(
                ()->{
//                    String getstr = aiApiController.sendGetRequest();
//                    System.out.println(getstr);
//                    aiApiController.sendGetRequest();
                    apiController.testai();
                }
        );
    }

    @DisplayName("퀴즈 보내주기")
    @Test
    public void getResponseSendingTest(){
        Assertions.assertDoesNotThrow(
                ()->{
                    List<QuizDTO>  dto = apiController.getQuizList();
                    dto.forEach(System.out::println);
                }
        );
    }




}

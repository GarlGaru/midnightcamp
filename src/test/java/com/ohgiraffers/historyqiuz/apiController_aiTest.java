package com.ohgiraffers.historyqiuz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class apiController_aiTest {

    @Autowired
    private apiController_ai apiController;

    @DisplayName("get요청 보내기")
    @Test
    public void getRequestSendingTest(){

        Assertions.assertDoesNotThrow(
                ()->{
//                    String getstr = apiController.sendGetRequest();
//                    System.out.println(getstr);
                    apiController.sendGetRequest();
                }
        );
    }

}

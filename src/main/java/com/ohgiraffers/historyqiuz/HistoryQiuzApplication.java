package com.ohgiraffers.historyqiuz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class HistoryQiuzApplication {

    public static void main(String[] args) {
        SpringApplication.run(HistoryQiuzApplication.class, args);
    }

}

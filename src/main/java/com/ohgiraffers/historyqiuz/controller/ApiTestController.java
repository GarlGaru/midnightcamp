package com.ohgiraffers.historyqiuz.controller;

import com.ohgiraffers.historyqiuz.dto.LeaderBoardDTO;
import com.ohgiraffers.historyqiuz.dto.QuizDTO;
import com.ohgiraffers.historyqiuz.service.LeaderBoardService;
import com.ohgiraffers.historyqiuz.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class ApiTestController {

    private final QuizService quizService;
    private final LeaderBoardService leaderBoardService;

    public ApiTestController(QuizService quizService, LeaderBoardService leaderBoardService) {
        this.quizService = quizService;
        this.leaderBoardService = leaderBoardService;
    }

    @GetMapping(value="test", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<QuizDTO> testjson() {
        System.out.println("testjson");
        return quizService.test();
    }

    @GetMapping(value="leaderboard", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<LeaderBoardDTO> leaderboardtestjson() {
        System.out.println("leaderboardtestjson");
        return leaderBoardService.test();
    }


}

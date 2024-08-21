package com.ohgiraffers.historyqiuz.controller;

import com.ohgiraffers.historyqiuz.dto.LeaderBoardDTO;
import com.ohgiraffers.historyqiuz.dto.QuizDTO;
import com.ohgiraffers.historyqiuz.service.LeaderBoardService;
import com.ohgiraffers.historyqiuz.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiController {


    private final QuizService quizService;
    private final LeaderBoardService leaderBoardService;
    private final apiController_ai aiController = new apiController_ai();

    public ApiController(QuizService quizService, LeaderBoardService leaderBoardService) {
        this.quizService = quizService;
        this.leaderBoardService = leaderBoardService;
    }

    @GetMapping(value="quizlist", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<QuizDTO> getQuizList() {
        List<QuizDTO> quizlist = quizService.getAllQuiz();
        //8개만 랜덤 추출
        Collections.shuffle(quizlist);
        List<QuizDTO>  result = quizlist.subList(0,8);

        //추출된 8개의 카운트 +1  //Todo : 비동기로 만들기
        quizService.countQuizLoaded(result);

        return result;
    }

    @GetMapping(value="leaderboard", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<LeaderBoardDTO> leaderboardtestjson() {
        System.out.println("leaderboardtestjson");
        return leaderBoardService.test();
    }
}

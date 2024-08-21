package com.ohgiraffers.historyqiuz.controller;

import com.ohgiraffers.historyqiuz.dto.LeaderBoardDTO;
import com.ohgiraffers.historyqiuz.dto.QuizDTO;
import com.ohgiraffers.historyqiuz.entity.Quiz;
import com.ohgiraffers.historyqiuz.service.LeaderBoardService;
import com.ohgiraffers.historyqiuz.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiController {


    private final QuizService quizService;
    private final LeaderBoardService leaderBoardService;
    private final apiController_ai aiController;

    public ApiController(QuizService quizService, LeaderBoardService leaderBoardService, apiController_ai aiController) {
        this.quizService = quizService;
        this.leaderBoardService = leaderBoardService;
        this.aiController = aiController;
    }

    @GetMapping(value="quizlist", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<QuizDTO> getQuizList() {
        List<Quiz> quizlist = quizService.getAllQuiz();
        //8개만 랜덤 추출
        List<Quiz> mutableQuizList  = new ArrayList<>(quizlist);
        Collections.shuffle(mutableQuizList);
        List<Quiz>  result = mutableQuizList.subList(0,8);

        //추출된 8개의 카운트 +1  //Todo : 비동기로 만들기
        quizService.countQuizLoaded(result);
//        checkQuizDB();

        return quizService.convertAllQuizDTO(result);
    }

    @GetMapping(value="dbcheck")
    @ResponseBody
    public void checkQuizDB(){
        List<Quiz> quizlist = quizService.getAllQuiz();
        List<Quiz> deleteList = new ArrayList<>();
        quizlist.forEach(
                quiz -> {
                    if (quiz.getCallCount() > 5){
                        deleteList.add(quiz);
                    }
                }
        );
        deleteList.forEach(quiz -> quizService.removeQuiz(quiz));
        System.out.println("threajiejwafwa");
    }

    public QuizDTO testai(){
        return aiController.sendGetRequest();
    }




    @PostMapping(value="/leaderboard", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<LeaderBoardDTO> leaderboardtestjson(@RequestParam String nickname, @RequestParam String score) {
        System.out.println("leaderboardtestjson");
        LeaderBoardDTO leaderBoardDTO = new LeaderBoardDTO(
                nickname,
                Integer.parseInt(score),
                LocalDateTime.now()
        );
        leaderBoardService.putNewRecord(leaderBoardDTO);
        return leaderBoardService.getLeaderBoard();
    }
}

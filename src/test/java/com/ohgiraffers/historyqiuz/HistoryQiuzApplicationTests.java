package com.ohgiraffers.historyqiuz;

import com.ohgiraffers.historyqiuz.controller.apiController_ai;
import com.ohgiraffers.historyqiuz.dto.LeaderBoardDTO;
import com.ohgiraffers.historyqiuz.dto.QuizDTO;
import com.ohgiraffers.historyqiuz.entity.Quiz;
import com.ohgiraffers.historyqiuz.service.LeaderBoardService;
import com.ohgiraffers.historyqiuz.service.QuizChoicesService;
import com.ohgiraffers.historyqiuz.service.QuizService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
class HistoryQiuzApplicationTests {

    @Autowired
    private QuizService quizService;

    @MockBean
    private QuizChoicesService quizChoicesService;

    @Autowired
    private LeaderBoardService leaderBoardService;

    @Autowired
    private apiController_ai aiApiController;

    @DisplayName("전체 조회 테스트")
    @Test
    void findAllQuiz(){
        Assertions.assertDoesNotThrow(
                ()->{
                    List<Quiz> quizs = quizService.getAllQuiz();
                    quizs.forEach(System.out::println);
                }
        );
    }

    @DisplayName("전체 조회 테스트")
    @Test
    void findAllLeaderBoard(){
        Assertions.assertDoesNotThrow(
                ()->{
                    List<LeaderBoardDTO> leaderBoard = leaderBoardService.getLeaderBoard();
                    leaderBoard.forEach(System.out::println);
                }
        );
    }

    @DisplayName("퀴즈 찾기")
    @Test
    void findQuizById() {
        Assertions.assertDoesNotThrow(
                ()->{
                    Quiz result = quizService.findSingleQuizByDetailby("테스트용 문제 이것은 문제 일까요?");
                    System.out.println(result);
                }
        );
    }


    @DisplayName("퀴즈 crud테스트 - regist")
    @Test
    public void CrudRegisterTest(){
        Assertions.assertDoesNotThrow(
                ()->{
                    QuizDTO response = aiApiController.sendGetRequest();
                    System.out.println(response);
                    quizService.registNewQuiz(response);
                }
        );
    }

}

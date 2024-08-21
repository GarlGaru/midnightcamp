package com.ohgiraffers.historyqiuz;

import com.ohgiraffers.historyqiuz.dto.LeaderBoardDTO;
import com.ohgiraffers.historyqiuz.dto.QuizDTO;
import com.ohgiraffers.historyqiuz.service.LeaderBoardService;
import com.ohgiraffers.historyqiuz.service.QuizService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HistoryQiuzApplicationTests {

    @Autowired
    private QuizService quizService;

    @Autowired
    private LeaderBoardService leaderBoardService;

    @DisplayName("전체 조회 테스트")
    @Test
    void findAllQuiz(){
        Assertions.assertDoesNotThrow(
                ()->{
                    List<QuizDTO> quizs = quizService.getAllQuiz();
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

}

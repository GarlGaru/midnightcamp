package com.ohgiraffers.historyqiuz.service;

import com.ohgiraffers.historyqiuz.dto.AnswerChoisesDTO;
import com.ohgiraffers.historyqiuz.dto.QuizDTO;
import com.ohgiraffers.historyqiuz.entity.QuizChoices;
import com.ohgiraffers.historyqiuz.repository.QuizChoicesRepository;
import com.ohgiraffers.historyqiuz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private QuizRepository quizRepository;
    private QuizChoicesRepository quizChoicesRepository;

    public QuizService() {
    }

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<QuizDTO> getAllQuiz() {
        return quizRepository.findAll()
                .stream()
                .map(quiz ->{
                    Optional<QuizChoices> optionalQuizChoices =
                            quizChoicesRepository.findById(quiz.getChoises().getChoicesCode());
                    if(optionalQuizChoices.isEmpty()) {
                        throw new NullPointerException("이 퀴즈 id 에 해당하는 선택지가 없습니다");
                    }
                    QuizChoices quizChoices = optionalQuizChoices.orElse(null);
                    return new QuizDTO(quiz, quizChoices);
                }
                )
                .toList();
    }



    public List<QuizDTO> test() {
        List<QuizDTO> list = new ArrayList<QuizDTO>();
        QuizDTO quiz = new QuizDTO();
        quiz.setQuiz("테스트용 문제 이것은 문제 일까요?");
        AnswerChoisesDTO answerChoisesDTO = new AnswerChoisesDTO();
        answerChoisesDTO.setChoiseOne("1번 선택지");
        answerChoisesDTO.setChoiseTwo("2번 선택지");
        answerChoisesDTO.setChoiseThree("3번 선택지");
        answerChoisesDTO.setChoiseFour("4번 선택지");
        quiz.setChoises(answerChoisesDTO);
        quiz.setAnswerNum(3);
        quiz.setDescription("This is a Description, 여기에 해설이 들어갑니다");
        list.add(quiz);
        list.add(quiz);
        list.add(quiz);
        return list;
    }
}

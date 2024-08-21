package com.ohgiraffers.historyqiuz.service;

import com.ohgiraffers.historyqiuz.dto.AnswerChoisesDTO;
import com.ohgiraffers.historyqiuz.dto.QuizDTO;
import com.ohgiraffers.historyqiuz.entity.Quiz;
import com.ohgiraffers.historyqiuz.entity.QuizChoices;
import com.ohgiraffers.historyqiuz.repository.QuizChoicesRepository;
import com.ohgiraffers.historyqiuz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class QuizService {

    private QuizRepository quizRepository;
    private QuizChoicesRepository quizChoicesRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository, QuizChoicesRepository quizChoicesRepository) {
        this.quizRepository = quizRepository;
        this.quizChoicesRepository = quizChoicesRepository;
    }

    @Transactional
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    public List<QuizDTO> convertAllQuizDTO(List<Quiz> quizList) {
        return quizList
                .stream()
                .map(quiz ->{
                            AnswerChoisesDTO answerChoisesDTO = new AnswerChoisesDTO(
                                    quiz.getChoises()
                            );

                            return new QuizDTO(
                                    quiz.getQuiz(),
                                    answerChoisesDTO,
                                    quiz.getAnswerNum(),
                                    quiz.getDescription()
                            );
                        }
                )
                .toList();
    }


    @Transactional
    public Quiz findSingleQuizByDetailby(String quizdetail) {
        return quizRepository.findByquizLike(quizdetail);
    }

    @Transactional
    public void registNewQuiz(QuizDTO quizDTO) {
        AnswerChoisesDTO answerChoisesDTO = quizDTO.getChoises();
//        QuizChoices quizChoices= quizChoicesService.registNewQuizChoice(answerChoisesDTO);

        QuizChoices quizChoices = new QuizChoices(
                answerChoisesDTO.getChoiseOne(),
                answerChoisesDTO.getChoiseTwo(),
                answerChoisesDTO.getChoiseThree(),
                answerChoisesDTO.getChoiseFour()
        );

        quizChoicesRepository.save(quizChoices);

        Quiz newQuiz = new Quiz(
                quizDTO.getQuiz(),
                quizChoices,
                quizDTO.getAnswerNum(),
                quizDTO.getDescription(),
                0
        );
        quizRepository.save(newQuiz);
    }

    @Transactional
    public void countQuizLoaded(List<Quiz> result) {
        result.forEach(
                quizDTO -> {
                    Quiz quiz = findSingleQuizByDetailby(quizDTO.getQuiz());
                    quiz.setCallCount(quiz.getCallCount() + 1);
                }
        );
        quizRepository.flush();
    }


    @Transactional
    public void removeQuiz(QuizDTO quizDTO) {
//        quizRepository.delete(quizDTO);
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

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
    private QuizChoicesService quizChoicesService;

    @Autowired
    public QuizService(QuizRepository quizRepository, QuizChoicesService quizChoicesService) {
        this.quizRepository = quizRepository;
        this.quizChoicesService = quizChoicesService;
    }

    @Transactional
    public List<QuizDTO> getAllQuiz() {
        return quizRepository.findAll()
                .stream()
                .map(quiz ->{
                    QuizChoices quizChoices = quizChoicesService.findQuizChoiceById(quiz.getChoises().getChoicesCode());
                    return new QuizDTO(quiz, quizChoices);
                }
                )
                .toList();
    }

    @Transactional
    public List<QuizDTO> findQuizByDetail(String quizdetail) {
        List<Quiz> quizList = quizRepository.findByquizContains(quizdetail);
//        List<Quiz> quizList = quizRepository.findByquizLike(quizdetail);
        if(quizList.isEmpty()) {
            throw new NoSuchElementException("해당하는 퀴즈가 없습니다");
        }
        return quizList.stream()
                .map(quiz ->{
                        QuizChoices quizChoices = quizChoicesService.findQuizChoiceById(quiz.getChoises().getChoicesCode());
                        return new QuizDTO(quiz, quizChoices);
                }
                )
                .toList();
    }

    @Transactional
    public void registNewQuiz(QuizDTO quizDTO) {
        Quiz newQuiz = new Quiz(
                quizDTO.getQuiz(),
                quizChoicesService.registNewQuizChoice(quizDTO.getChoises()),
                quizDTO.getAnswerNum(),
                quizDTO.getDescription(),
                0
        );
        quizRepository.save(newQuiz);
    }

    public void countQuizLoaded(List<QuizDTO> result) {


    }


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

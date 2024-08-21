package com.ohgiraffers.historyqiuz.service;

import com.ohgiraffers.historyqiuz.dto.AnswerChoisesDTO;
import com.ohgiraffers.historyqiuz.dto.QuizDTO;
import com.ohgiraffers.historyqiuz.entity.QuizChoices;
import com.ohgiraffers.historyqiuz.repository.QuizChoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class QuizChoicesService {

    private QuizChoicesRepository quizChoicesRepository;

    @Autowired
    public QuizChoicesService(QuizChoicesRepository quizChoicesRepository) {
        this.quizChoicesRepository = quizChoicesRepository;
    }


    @Transactional
    public QuizChoices findQuizChoiceById(int choicesCode) {
        Optional<QuizChoices> optionalQuizChoices =
                quizChoicesRepository.findById(choicesCode);
        if(optionalQuizChoices.isEmpty()) {
            throw new NoSuchElementException("이 퀴즈 id 에 해당하는 선택지가 없습니다");
        }
        return optionalQuizChoices.get();
    }

    @Transactional
    public void registNewQuizChoice(QuizChoices choices) {
        System.out.println("answerChoisesDTO");
        quizChoicesRepository.save(choices);
    }

    @Transactional
    public void removeChoice(int choicesCode) {
        quizChoicesRepository.deleteById(choicesCode);
    }


}

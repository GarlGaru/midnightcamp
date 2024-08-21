package com.ohgiraffers.historyqiuz.dto;

import com.ohgiraffers.historyqiuz.entity.Quiz;
import com.ohgiraffers.historyqiuz.entity.QuizChoices;


public class QuizDTO {

    String quiz;
    AnswerChoisesDTO choises;
    int answerNum;
    String description;


    public QuizDTO() {
    }

    public QuizDTO(String quiz, AnswerChoisesDTO choises, int answerNum, String description) {
        this.quiz = quiz;
        this.choises = choises;
        this.answerNum = answerNum;
        this.description = description;
    }


    public QuizDTO(Quiz quiz, QuizChoices byId) {
        this(
                quiz.getQuiz(),
                new AnswerChoisesDTO(byId) ,
                quiz.getAnswerNum(),
                quiz.getDescription()
        );
    }


    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public AnswerChoisesDTO getChoises() {
        return choises;
    }

    public void setChoises(AnswerChoisesDTO choises) {
        this.choises = choises;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "QuizDTO{" +
                "quiz='" + quiz + '\'' +
                ", choises=" + choises +
                ", answerNum=" + answerNum +
                ", description='" + description + '\'' +
                '}';
    }
}

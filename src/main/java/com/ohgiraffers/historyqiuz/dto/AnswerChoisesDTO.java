package com.ohgiraffers.historyqiuz.dto;

import com.ohgiraffers.historyqiuz.entity.Quiz;
import com.ohgiraffers.historyqiuz.entity.QuizChoices;

public class AnswerChoisesDTO {

    String choiseOne, choiseTwo, choiseThree, choiseFour;

    public AnswerChoisesDTO() {
    }

    public AnswerChoisesDTO(QuizChoices quizChoices) {
        this(
                quizChoices.getChoiseOne(),
                quizChoices.getChoiseTwo(),
                quizChoices.getChoiseThree(),
                quizChoices.getChoiseFour()
        );
    }

    public AnswerChoisesDTO(String choiseOne, String choiseTwo, String choiseThree, String choiseFour) {
        this.choiseOne = choiseOne;
        this.choiseTwo = choiseTwo;
        this.choiseThree = choiseThree;
        this.choiseFour = choiseFour;
    }

    public String getChoiseOne() {
        return choiseOne;
    }

    public void setChoiseOne(String choiseOne) {
        this.choiseOne = choiseOne;
    }

    public String getChoiseTwo() {
        return choiseTwo;
    }

    public void setChoiseTwo(String choiseTwo) {
        this.choiseTwo = choiseTwo;
    }

    public String getChoiseThree() {
        return choiseThree;
    }

    public void setChoiseThree(String choiseThree) {
        this.choiseThree = choiseThree;
    }

    public String getChoiseFour() {
        return choiseFour;
    }

    public void setChoiseFour(String choiseFour) {
        this.choiseFour = choiseFour;
    }

    @Override
    public String toString() {
        return "AnswerChoises{" +
                "choiseOne='" + choiseOne + '\'' +
                ", choiseTwo='" + choiseTwo + '\'' +
                ", choiseThree='" + choiseThree + '\'' +
                ", choiseFour='" + choiseFour + '\'' +
                '}';
    }
}

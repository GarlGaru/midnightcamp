package com.ohgiraffers.historyqiuz.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tbl_choices")
public class QuizChoices {

    @Id
    @Column(name = "choices_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int choicesCode;

    @Column(name = "choise_one")
    private String choiseOne;

    @Column(name = "choise_two")
    private String choiseTwo;

    @Column(name = "choise_three")
    private String choiseThree;

    @Column(name = "choise_four")
    private String choiseFour;


    public QuizChoices() {
    }

    public QuizChoices(String choiseOne, String choiseTwo, String choiseThree, String choiseFour) {
        this.choiseOne = choiseOne;
        this.choiseTwo = choiseTwo;
        this.choiseThree = choiseThree;
        this.choiseFour = choiseFour;
    }

    public int getChoicesCode() {
        return choicesCode;
    }

    public String getChoiseOne() {
        return choiseOne;
    }

    public String getChoiseTwo() {
        return choiseTwo;
    }

    public String getChoiseThree() {
        return choiseThree;
    }

    public String getChoiseFour() {
        return choiseFour;
    }

    @Override
    public String toString() {
        return "QuizChoices{" +
                "choicesCode=" + choicesCode +
                ", choiseOne='" + choiseOne + '\'' +
                ", choiseTwo='" + choiseTwo + '\'' +
                ", choiseThree='" + choiseThree + '\'' +
                ", choiseFour='" + choiseFour + '\'' +
                '}';
    }
}

package com.ohgiraffers.historyqiuz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_quiz")
public class Quiz {

    @Id
    @Column(name = "quiz_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quizCode;

    @Column(name = "quiz_detail")
    private String quiz;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "choices_code")
    private QuizChoices choises;

    @Column(name = "answer_num")
    private int answerNum;

    @Column(name = "description")
    private String description;

    @Column(name = "call_count")
    private int callCount;

    protected Quiz() {
    }

    public Quiz(String quiz, QuizChoices choises, int answerNum, String description, int callCount) {
        this.quiz = quiz;
        this.choises = choises;
        this.answerNum = answerNum;
        this.description = description;
        this.callCount = callCount;
    }


    public int getQuizCode() {
        return quizCode;
    }

    public String getQuiz() {
        return quiz;
    }

    public QuizChoices getChoises() {
        return choises;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public String getDescription() {
        return description;
    }

    public int getCallCount() {
        return callCount;
    }

    public void setCallCount(int callCount) {
        this.callCount = callCount;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizCode=" + quizCode +
                ", quiz='" + quiz + '\'' +
                ", choises=" + choises +
                ", answerNum=" + answerNum +
                ", description='" + description + '\'' +
                ", callCount=" + callCount +
                '}';
    }
}

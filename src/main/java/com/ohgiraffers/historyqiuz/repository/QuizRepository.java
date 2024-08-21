package com.ohgiraffers.historyqiuz.repository;

import com.ohgiraffers.historyqiuz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    List<Quiz> findByquizContains(String quiz);

    Quiz findByquizLike(String quizdetail);
}

package com.ohgiraffers.historyqiuz.repository;

import com.ohgiraffers.historyqiuz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}

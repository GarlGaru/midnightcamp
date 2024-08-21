package com.ohgiraffers.historyqiuz.repository;

import com.ohgiraffers.historyqiuz.entity.QuizChoices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizChoicesRepository extends JpaRepository<QuizChoices, Integer> {
}

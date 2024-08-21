package com.ohgiraffers.historyqiuz.repository;

import com.ohgiraffers.historyqiuz.entity.QuizChoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizChoicesRepository extends JpaRepository<QuizChoices, Integer> {
}

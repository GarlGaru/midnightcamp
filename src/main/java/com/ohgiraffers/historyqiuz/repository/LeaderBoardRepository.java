package com.ohgiraffers.historyqiuz.repository;

import com.ohgiraffers.historyqiuz.entity.LeaderBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderBoardRepository extends JpaRepository<LeaderBoard, Integer> {
}

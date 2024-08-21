package com.ohgiraffers.historyqiuz.repository;

import com.ohgiraffers.historyqiuz.entity.LeaderBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderBoardRepository extends JpaRepository<LeaderBoard, Long> {
}

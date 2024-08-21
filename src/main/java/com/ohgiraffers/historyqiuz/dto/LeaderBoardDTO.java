package com.ohgiraffers.historyqiuz.dto;

import com.ohgiraffers.historyqiuz.entity.LeaderBoard;

import java.time.LocalDateTime;

public class LeaderBoardDTO {
    private String NickName;
    private int Score;
    private LocalDateTime ClearTime;

    public LeaderBoardDTO() {
    }

    public LeaderBoardDTO(String nickName, int score, LocalDateTime clearTime) {
        NickName = nickName;
        Score = score;
        ClearTime = clearTime;
    }

    public LeaderBoardDTO(LeaderBoard leaderBoard) {
        this(
                leaderBoard.getNickName(),
                leaderBoard.getScore(),
                leaderBoard.getClearTime()
        );
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public LocalDateTime getClearTime() {
        return ClearTime;
    }

    public void setClearTime(LocalDateTime clearTime) {
        ClearTime = clearTime;
    }

    @Override
    public String toString() {
        return "LeaderBoardDTO{" +
                "NickName='" + NickName + '\'' +
                ", Score=" + Score +
                ", ClearTime=" + ClearTime +
                '}';
    }
}

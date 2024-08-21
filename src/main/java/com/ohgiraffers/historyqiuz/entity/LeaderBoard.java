package com.ohgiraffers.historyqiuz.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_leaderboard")
public class LeaderBoard {

    @Id
    @Column(name = "board_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardCode;

    @Column(name = "nickname")
    private String NickName;

    @Column(name = "score")
    private int Score;

    @Column(name = "clear_time")
    private LocalDateTime ClearTime;

    protected LeaderBoard() {}

    public LeaderBoard(String nickName, int score, LocalDateTime clearTime) {
        this.NickName = nickName;
        this.Score = score;
        this.ClearTime = clearTime;
    }

    public int getBoardCode() {
        return boardCode;
    }

    public String getNickName() {
        return NickName;
    }

    public int getScore() {
        return Score;
    }

    public LocalDateTime getClearTime() {
        return ClearTime;
    }

    @Override
    public String toString() {
        return "LeaderBoard{" +
                "boardCode='" + boardCode + '\'' +
                ", NickName='" + NickName + '\'' +
                ", Score=" + Score +
                ", ClearTime=" + ClearTime +
                '}';
    }
}

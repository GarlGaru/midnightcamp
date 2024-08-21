package com.ohgiraffers.historyqiuz.service;

import com.ohgiraffers.historyqiuz.dto.LeaderBoardDTO;
import com.ohgiraffers.historyqiuz.entity.LeaderBoard;
import com.ohgiraffers.historyqiuz.repository.LeaderBoardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeaderBoardService {

    LeaderBoardRepository leaderBoardRepository;

    public LeaderBoardService() {

    }

    public LeaderBoardService(LeaderBoardRepository leaderBoardRepository) {
        this.leaderBoardRepository = leaderBoardRepository;
    }

    public List<LeaderBoardDTO> getLeaderBoard() {
        System.out.println(leaderBoardRepository.findAll());
        return leaderBoardRepository.findAll()
                .stream()
                .map(LeaderBoardDTO::new)
                .toList();
    }

    public List<LeaderBoardDTO> test() {
        List<LeaderBoardDTO> list = new ArrayList<>();
        LeaderBoardDTO leaderBoardDTO = new LeaderBoardDTO();
        leaderBoardDTO.setNickName("테스트용닉네임");
        leaderBoardDTO.setScore(11560);
        leaderBoardDTO.setClearTime(LocalDateTime.now());
        list.add(leaderBoardDTO);

        LeaderBoardDTO leaderBoardDTO2 = new LeaderBoardDTO();
        leaderBoardDTO2.setNickName("테스트용닉네임");
        leaderBoardDTO2.setScore(15155);
        leaderBoardDTO2.setClearTime(LocalDateTime.now());
        list.add(leaderBoardDTO2);

        LeaderBoardDTO leaderBoardDTO3 = new LeaderBoardDTO();
        leaderBoardDTO3.setNickName("test 닉네임");
        leaderBoardDTO3.setScore(21260);
        leaderBoardDTO3.setClearTime(LocalDateTime.now());
        list.add(leaderBoardDTO3);

        LeaderBoardDTO leaderBoardDTO4 = new LeaderBoardDTO();
        leaderBoardDTO4.setNickName("test 닉네임");
        leaderBoardDTO4.setScore(2260);
        leaderBoardDTO4.setClearTime(LocalDateTime.now());
        list.add(leaderBoardDTO4);

        LeaderBoardDTO leaderBoardDTO5 = new LeaderBoardDTO();
        leaderBoardDTO5.setNickName("test 닉네임");
        leaderBoardDTO5.setScore(2260);
        leaderBoardDTO5.setClearTime(LocalDateTime.now());
        list.add(leaderBoardDTO5);

        LeaderBoardDTO leaderBoardDTO6 = new LeaderBoardDTO();
        leaderBoardDTO6.setNickName("test 닉네임");
        leaderBoardDTO6.setScore(1260);
        leaderBoardDTO6.setClearTime(LocalDateTime.now());
        list.add(leaderBoardDTO6);

        return list;
    }
}

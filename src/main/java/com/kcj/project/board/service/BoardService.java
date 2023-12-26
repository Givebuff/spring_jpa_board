package com.kcj.project.board.service;

import com.kcj.project.board.model.Board;
import com.kcj.project.board.model.Member;
import com.kcj.project.board.repository.BoardRepository;
import com.kcj.project.board.util.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired private BoardRepository boardRepository;
    @Autowired private MemberService memberService;


    public Board save(Board board){
        return  boardRepository.save(board);
    }

    public Board findById(Long id){
        return boardRepository.findById(id).orElse(null);
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public List<Board> findByTitle(String title){
        return boardRepository.findByName(title);
    }

    public List<Board> findByTitleLike(String title, int idx){
        return boardRepository.findByNameLike(DatabaseUtil.like(title, idx));
    }

    public List<Board> findByMemberAndTitleLike(Member member, String title, int idx){
        return boardRepository.findByRegMemberAndNameLike(member, DatabaseUtil.like(title, idx));
    }

    public List<Board> findByMember(Member member){
        return boardRepository.findByRegMember(member);
    }

    public List<Board> findByMemberName(String memberName){
        List<Board> boards = new ArrayList<>();

        memberService.findByName(memberName).forEach(member -> {
            boards.addAll(findByMember(member));
        });

        return boards;
    }

    public void defaultBoardSetting(){
        boardRepository.save(defaultBoard());
    }

    private Board defaultBoard(){
        Board board = new Board();

        board.setName("Init Title");
        board.setContent("Init Content <br> This is Content");
        board.setViewCount(1);

        return board;
    }
}

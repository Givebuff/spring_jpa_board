package com.kcj.project.board.service;

import com.kcj.project.board.model.Board;
import com.kcj.project.board.model.Like;
import com.kcj.project.board.model.Member;
import com.kcj.project.board.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public Like save(Like like){
        return likeRepository.save(like);
    }

    public Like findById(Long id){
        return likeRepository.findById(id).orElse(null);
    }

    public List<Like> findAll(){
        return likeRepository.findAll();
    }

    public List<Like> findByMember(Member member){
        return likeRepository.findByRegMember(member);
    }

    public List<Like> findByBoard(Board board){
        return likeRepository.findByBoard(board);
    }

    public Long countByMember(Member member){
        return likeRepository.countByRegMember(member);
    }

    public Long countByBoard(Board board){
        return likeRepository.countByBoard(board);
    }
}

package com.kcj.project.board.service;

import com.kcj.project.board.model.Board;
import com.kcj.project.board.model.Comment;
import com.kcj.project.board.model.Member;
import com.kcj.project.board.repository.CommentRepository;
import com.kcj.project.board.util.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired private CommentRepository commentRepository;

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public Comment findById(Long id){
        return commentRepository.findById(id).orElse(null);
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public List<Comment> findByMember(Member member){
        return commentRepository.findByRegMember(member);
    }

    public List<Comment> findByBoard(Board board){
        return commentRepository.findByBoard(board);
    }

    public List<Comment> findByContentLike(String content, int idx){
        return commentRepository.findByContentLike(DatabaseUtil.like(content, idx));
    }

    public List<Comment> findByMemberAndContentLike(Member member, String content, int idx){
        return commentRepository.findByRegMemberAndContentLike(member, DatabaseUtil.like(content, idx));
    }
}

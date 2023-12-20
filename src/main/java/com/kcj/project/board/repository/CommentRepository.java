package com.kcj.project.board.repository;

import com.kcj.project.board.model.Board;
import com.kcj.project.board.model.Comment;
import com.kcj.project.board.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRegMember(Member member);

    List<Comment> findByBoard(Board board);

    List<Comment> findByContentLike(String content);

    List<Comment> findByRegMemberAndContentLike(Member member, String content);
}

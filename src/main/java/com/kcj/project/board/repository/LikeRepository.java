package com.kcj.project.board.repository;

import com.kcj.project.board.model.Board;
import com.kcj.project.board.model.Like;
import com.kcj.project.board.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByRegMember(Member member);

    List<Like> findByBoard(Board board);

    Long countByRegMember(Member member);

    Long countByBoard(Board board);
}

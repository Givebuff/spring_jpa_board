package com.kcj.project.board.repository;

import com.kcj.project.board.model.Board;
import com.kcj.project.board.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByName(String title); // 공통 컬럼 name을 title로 변경하여 사용 중

    List<Board> findByRegMember(Member member);
}

package com.kcj.project.board.repository;

import com.kcj.project.board.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}

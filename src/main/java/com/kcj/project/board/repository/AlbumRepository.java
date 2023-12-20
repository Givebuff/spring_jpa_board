package com.kcj.project.board.repository;

import com.kcj.project.board.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
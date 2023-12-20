package com.kcj.project.board.repository;

import com.kcj.project.board.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findBySizeLessThan(Long maxSize);

    List<Album> findBySizeGreaterThan(Long minSize);

    List<Album> findBySizeBetween(Long minSize, Long maxSize);

    List<Album> findBySize(Long size);
}
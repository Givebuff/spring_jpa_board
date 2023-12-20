package com.kcj.project.board.service;

import com.kcj.project.board.model.Album;
import com.kcj.project.board.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public Album save(Album album){
        return albumRepository.save(album);
    }

    public Album findById(Long id){
        return albumRepository.findById(id).orElse(null);
    }

    public List<Album> findAll(){
        return albumRepository.findAll();
    }

    public List<Album> findBySizeLessThan(Long maxSize){
        return albumRepository.findBySizeLessThan(maxSize);
    }

    public List<Album> findBySizeGreaterThan(Long minSize){
        return albumRepository.findBySizeGreaterThan(minSize);
    }

    public List<Album> findBySizeBetween(Long minSize, Long maxSize){
        return albumRepository.findBySizeBetween(minSize, maxSize);
    }

    public List<Album> findBySize(Long size){
        return albumRepository.findBySize(size);
    }
}

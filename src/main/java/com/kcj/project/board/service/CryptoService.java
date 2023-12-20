package com.kcj.project.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CryptoService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String getPassword(String password){
        return passwordEncoder.encode(password);
    }
}

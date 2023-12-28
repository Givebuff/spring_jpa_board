package com.kcj.project.board.controller;

import com.kcj.project.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/mail/test")
    public String mailTest(){
        return "redirect:/login";
    }
}

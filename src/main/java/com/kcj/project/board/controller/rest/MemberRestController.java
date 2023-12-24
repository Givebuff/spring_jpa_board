package com.kcj.project.board.controller.rest;

import com.kcj.project.board.model.Member;
import com.kcj.project.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/test")
    public Member test(){
        memberService.defaultUserSetting();
        return memberService.findByMemberId("admin");
    }
}

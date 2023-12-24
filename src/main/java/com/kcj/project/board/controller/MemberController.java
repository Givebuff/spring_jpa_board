package com.kcj.project.board.controller;

import com.kcj.project.board.model.Member;
import com.kcj.project.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/login/fail/{memberId}")
    public String loginFail(@PathVariable("memberId") String memberId){
        Member member = memberService.findByMemberId(memberId);

        if(member != null) memberService.loginFail(member);

        return "/login";
    }
}

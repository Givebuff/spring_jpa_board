package com.kcj.project.board.controller.rest;

import com.kcj.project.board.model.Member;
import com.kcj.project.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/api/test")
    public Member test(){
        memberService.defaultUserSetting();
        return memberService.findByMemberId("admin");
    }

    @GetMapping("/api/member/id/duplication/{memberId}")
    public boolean memberIdDuplication(@PathVariable("memberId") String memberId){
        return memberService.findByMemberId(memberId) == null;
    }
}

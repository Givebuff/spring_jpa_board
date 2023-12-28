package com.kcj.project.board.controller;

import com.kcj.project.board.model.Member;
import com.kcj.project.board.service.MemberService;
import com.kcj.project.board.util.LoginFailMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/login/fail/id/{memberId}")
    public String loginFailId(@PathVariable("memberId") String memberId, RedirectAttributes redirectAttributes){
        Member member = memberService.findByMemberId(memberId);

        if(member != null) memberService.loginFail(member);

        redirectAttributes.addAttribute("message", LoginFailMessageUtil.getFailTag("FOUND"));

        return "redirect:/login";
    }

    @GetMapping("/login/fail/tag/{tag}")
    public String loginFailTag(@PathVariable("tag") String tag, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", LoginFailMessageUtil.getFailTag(tag));

        return "redirect:/login";
    }

    @GetMapping("/registry")
    public String registryMemberPage(){
        return "/registry";
    }

    @PostMapping("/registry")
    public String registryMember(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("memberId") String memberId,
            @RequestParam("password") String password,
            @RequestParam("profile") List<MultipartFile> profile,
            Model model
    ){
        String page = "redirect:/login";



        return page;
    }
}

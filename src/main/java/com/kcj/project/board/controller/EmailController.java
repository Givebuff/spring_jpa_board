package com.kcj.project.board.controller;

import com.kcj.project.board.model.Member;
import com.kcj.project.board.service.EmailService;
import com.kcj.project.board.service.MemberService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private EmailService emailService;

    @Value("${board.domain}")
    private String domain;

    @GetMapping("/email/test")
    public String sendEmail() {
        String to = "ckdwls0275@gmail.com";
        String subject = "Test Email";
        String body = "This is a test email sent from Spring Boot.";

        emailService.sendEmail(to, subject, body);

        return "redirect:/login";
    }

    @PostMapping("/email/forget/id")
    public String forgetId(@RequestParam("memberId") String memberId, @RequestParam("email") String email, RedirectAttributes redirectAttributes) {
        Member member = memberService.findByMemberId(memberId);
        String title = "forget board id";
        String content = "init password url : "
                + domain
                + "/email/forget/id"
                + "/" + memberId
                + "/" + member.getPassword();

        if(member.getEmail().equals(email)){
            emailService.sendEmail(email, title, content);
            redirectAttributes.addFlashAttribute("message", "Email을 발송하였습니다. 확인 후 로그인 해 주세요.");
            return "redirect:/login";
        }

        redirectAttributes.addFlashAttribute("message", "존재하지 않는 ID, Email입니다.");

        return "redirect:/member/forget";
    }

    @GetMapping("/email/forget/id/{memberId}/{password}")
    public String initPassword(@PathVariable("memberId") String memberId, @PathVariable("password") String password){
        Member member = memberService.findByMemberId(memberId);

        if(member.getPassword().equals(password)) memberService.initPassword(member);

        return "redirect:/login";
    }
}

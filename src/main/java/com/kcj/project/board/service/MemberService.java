package com.kcj.project.board.service;

import com.kcj.project.board.model.Member;
import com.kcj.project.board.model.MemberRole;
import com.kcj.project.board.model.MemberStatus;
import com.kcj.project.board.repository.MemberRepository;
import com.kcj.project.board.util.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired private MemberRepository memberRepository;
    @Autowired private CryptoService cryptoService;

    public Member findById(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findByMemberId(String memberId){
        return memberRepository.findByMemberId(memberId);
    }

    public List<Member> findByMemberIdLike(String memberId, int idx){
        return memberRepository.findByMemberIdLike(DatabaseUtil.like(memberId, idx));
    }

    public List<Member> findByName(String name){
        return memberRepository.findByName(name);
    }

    public List<Member> findByNameLike(String name, int idx){
        return memberRepository.findByNameLike(DatabaseUtil.like(name, idx));
    }

    public List<Member> findByStatus(MemberStatus status){
        return memberRepository.findByStatus(status);
    }

    public List<Member> findByRole(MemberRole role){
        return memberRepository.findByRole(role);
    }

    public void defaultUserSetting(){
        if(findByMemberId("member") != null) memberRepository.save(defaultMember());
        if(findByMemberId("admin") != null) memberRepository.save(defaultAdmin());
    }

    protected Member defaultMember(){
        Member member = new Member();

        member.setMemberId("member");
        member.setPassword(cryptoService.getPassword("1234"));
        member.setName("Member");
        member.setRole(MemberRole.USER);
        member.setStatus(MemberStatus.JOIN);

        return member;
    }

    private Member defaultAdmin(){
        Member member = new Member();

        member.setMemberId("admin");
        member.setPassword(cryptoService.getPassword("1234"));
        member.setName("Admin");
        member.setRole(MemberRole.ADMIN);
        member.setStatus(MemberStatus.JOIN);

        return member;
    }
}

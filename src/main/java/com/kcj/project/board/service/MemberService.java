package com.kcj.project.board.service;

import com.kcj.project.board.detail.MemberDetail;
import com.kcj.project.board.model.Member;
import com.kcj.project.board.model.MemberRole;
import com.kcj.project.board.model.MemberStatus;
import com.kcj.project.board.repository.MemberRepository;
import com.kcj.project.board.util.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements UserDetailsService {
    @Autowired private MemberRepository memberRepository;
    @Autowired private CryptoService cryptoService;
    @Value("@{board.login.fail.max.count}")
    private String loginFailMaxCount;

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

    public void loginFail(Member member){
        int failCount = member.getFailCount() + 1;

        if(Integer.parseInt(loginFailMaxCount) == failCount){
            member.setFailCount(0);
            member.setStatus(MemberStatus.LOCK);
        } else {
            member.setFailCount(failCount);
        }
    }

    public void defaultUserSetting(){
        if(findByMemberId("member") == null) memberRepository.save(defaultMember());
        if(findByMemberId("admin") == null) memberRepository.save(defaultAdmin());
    }

    protected Member defaultMember(){
        Member member = new Member();

        member.setMemberId("member");
        member.setPassword(cryptoService.getPassword("1234"));
        member.setName("Member");
        member.getRole().add(MemberRole.USER);
        member.getRole().add(MemberRole.GUEST);
        member.setStatus(MemberStatus.JOIN);

        return member;
    }

    private Member defaultAdmin(){
        Member member = new Member();

        member.setMemberId("admin");
        member.setPassword(cryptoService.getPassword("1234"));
        member.setName("Admin");
        member.getRole().add(MemberRole.ADMIN);
        member.getRole().add(MemberRole.USER);
        member.getRole().add(MemberRole.GUEST);
        member.setStatus(MemberStatus.JOIN);

        return member;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = findByMemberId(username);
        if(member == null){
            throw new UsernameNotFoundException("Login Fail");
        }

        return new MemberDetail(member);
    }
}

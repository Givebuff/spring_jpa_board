package com.kcj.project.board.detail;

import com.kcj.project.board.model.Member;
import com.kcj.project.board.model.MemberStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MemberDetail implements UserDetails {
    private final Member member;

    public MemberDetail(Member member){
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getMemberId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return (member.getStatus() != MemberStatus.TIMEOUT);
    }

    @Override
    public boolean isAccountNonLocked() {
        return (member.getStatus() != MemberStatus.LOCK);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return (member.getStatus() != MemberStatus.CREDENTIAL);
    }

    @Override
    public boolean isEnabled() {
        return (member.getStatus() != MemberStatus.ENABLE);
    }
}

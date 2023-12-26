package com.kcj.project.board.detail;

import com.kcj.project.board.model.Member;
import com.kcj.project.board.model.MemberRole;
import com.kcj.project.board.model.MemberStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class MemberDetail implements UserDetails {
    private final Member member;
    @Value("${board.role.prefix}")
    private String rolePrefix;

    public MemberDetail(Member member){
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();

        for (MemberRole role: member.getRole())
            collection.add(new SimpleGrantedAuthority(rolePrefix + role));

        return collection;
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

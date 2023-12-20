package com.kcj.project.board.repository;

import com.kcj.project.board.model.Like;
import com.kcj.project.board.model.Member;
import com.kcj.project.board.model.MemberRole;
import com.kcj.project.board.model.MemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);

    List<Member> findByNameLike(String name);

    Member findByMemberId(String memberId);

    List<Member> findByMemberIdLike(String MemberId);

    List<Member> findByStatus(MemberStatus status);

    List<Member> findByRole(MemberRole role);
}
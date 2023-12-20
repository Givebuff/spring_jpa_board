package com.kcj.project.board.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends BaseModel {
    @Column(unique = true)
    private String memberId;

    private String password;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @OneToOne
    private Album profile;

    @OneToMany(mappedBy = "regMember")
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "regMember")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "regMember")
    private List<Like> likes = new ArrayList<>();
}

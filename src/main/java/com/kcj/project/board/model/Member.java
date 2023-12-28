package com.kcj.project.board.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends BaseModel {
    @Column(unique = true)
    private String memberId;

    private String password;

    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "MemberRole", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    private Set<MemberRole> role = new HashSet<>();

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

    private Integer failCount = 0;
}

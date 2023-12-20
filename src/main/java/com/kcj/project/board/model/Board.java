package com.kcj.project.board.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AttributeOverride(name = "name", column = @Column(name = "title"))
public class Board extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "REG_MEMBER")
    private Member regMember;

    @Lob
    private String content;

    @ColumnDefault("0")
    private int viewCount;

    @OneToOne
    private Album thumbNail;

    @OneToMany(mappedBy = "board")
    @Cascade(CascadeType.ALL)
    private List<Album> albums = new ArrayList<>();

    @OneToMany(mappedBy = "board")
    @Cascade(CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "board")
    @Cascade(CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();
}

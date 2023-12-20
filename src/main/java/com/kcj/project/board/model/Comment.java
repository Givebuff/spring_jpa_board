package com.kcj.project.board.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends BaseModel{
    private String content;

    @ManyToOne
    private Member regMember;

    @ManyToOne
    private Board board;

    private int pIdx;

    private int cIdx;
}

package com.kcj.project.board.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BOARD_LIKE")
@Getter
@Setter
@NoArgsConstructor
public class Like extends BaseModel{
    @ManyToOne
    private Board board;

    @ManyToOne
    private Member regMember;
}

package com.kcj.project.board.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Album extends BaseModel{
    private String subName;

    private String directory;

    @ManyToOne
    private Board board;
}

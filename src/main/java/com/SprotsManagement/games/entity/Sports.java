package com.SprotsManagement.games.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
//Entity layer for sports table

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sports")
public class Sports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="sport", nullable = false, unique = true)
    private String sport;

    @Column(name = "isTeamGame", nullable = false)
    private Boolean isTeamGame;

    @Column(name="minPlayers", nullable = false)
    private int minPlayers;

    @Column(name="maxPlayers", nullable = false)
    private int maxPlayers;


    @OneToMany(mappedBy = "sports", cascade = CascadeType.ALL)
    private List<Teams> children;
}

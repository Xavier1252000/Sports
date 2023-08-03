package com.SprotsManagement.games.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


// Entity layer for teams table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="teams")
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String teamName;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "noOfPlayers", nullable = false)
    private int noOfPlayers;

    @Column(name = "sportsName")
    private String sportsName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sportsId", nullable = false)
    private Sports sports;

}

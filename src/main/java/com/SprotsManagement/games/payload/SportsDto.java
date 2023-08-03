package com.SprotsManagement.games.payload;

import lombok.Data;

import javax.persistence.Column;

@Data
public class SportsDto {
    private long id;
    @Column(unique = true)
    private String sport;
    private Boolean isTeamGame;
    private int minPlayers;
    private int maxPlayers;
}

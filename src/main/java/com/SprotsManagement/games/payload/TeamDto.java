package com.SprotsManagement.games.payload;

import lombok.Data;

@Data
public class TeamDto {
    private long id;
    private String city;
    private String teamName;
    private int noOfPlayers;
    private long sportsId;
}

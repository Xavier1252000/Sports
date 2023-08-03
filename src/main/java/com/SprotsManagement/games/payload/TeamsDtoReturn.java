package com.SprotsManagement.games.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamsDtoReturn {
    private long id;
    private String city;
    private String teamName;
    private int noOfPlayers;
    private String sportsName;
}

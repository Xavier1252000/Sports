package com.SprotsManagement.games.services.impl;

import com.SprotsManagement.games.entity.Teams;
import com.SprotsManagement.games.payload.TeamDto;
import com.SprotsManagement.games.payload.TeamsDtoReturn;

import java.util.List;

public interface TeamServices {
    TeamsDtoReturn addTeam(TeamDto teamDto);

    List<TeamsDtoReturn> getAllTeams();


    List<TeamsDtoReturn> getTeamsByCity(String city);
}

package com.SprotsManagement.games.controller;

import com.SprotsManagement.games.entity.Teams;
import com.SprotsManagement.games.payload.SportsDto;
import com.SprotsManagement.games.payload.TeamDto;
import com.SprotsManagement.games.payload.TeamsDtoReturn;
import com.SprotsManagement.games.services.impl.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamServices teamServices;



    @PostMapping("/create-team")
    public ResponseEntity<TeamsDtoReturn> addTeams(@RequestBody TeamDto teamDto){
        return new ResponseEntity<>(teamServices.addTeam(teamDto), HttpStatus.CREATED);
    }

    @GetMapping("/get-teams")
    public ResponseEntity<List<TeamsDtoReturn>> getAllTeams(){
        return new ResponseEntity<>(teamServices.getAllTeams(), HttpStatus.OK);
    }



    // Get all the teams by city
    @GetMapping("/get-team")
    public ResponseEntity<List<TeamsDtoReturn>> getTeamsByCity(
            @RequestParam(value = "city", required = false)String city
    ){
        List<TeamsDtoReturn> teamsByCity = teamServices.getTeamsByCity(city);
        return new ResponseEntity<>(teamsByCity, HttpStatus.OK);
    }
}

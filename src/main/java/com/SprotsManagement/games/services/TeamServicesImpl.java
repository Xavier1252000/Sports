package com.SprotsManagement.games.services;

import com.SprotsManagement.games.entity.Sports;
import com.SprotsManagement.games.entity.Teams;
import com.SprotsManagement.games.exceptions.ResourceNotFoundException;
import com.SprotsManagement.games.payload.TeamDto;
import com.SprotsManagement.games.payload.TeamsDtoReturn;
import com.SprotsManagement.games.repository.SportsRepository;
import com.SprotsManagement.games.repository.TeamsRepository;
import com.SprotsManagement.games.services.impl.TeamServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServicesImpl implements TeamServices {

    @Autowired
    private TeamsRepository teamsRepository;

    @Autowired
    private SportsRepository sportsRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public TeamsDtoReturn addTeam(TeamDto teamDto) {
        long id = teamDto.getSportsId();
        Sports sports = sportsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("sport", "id", id)
        );
        Teams teams = mapToEntity(teamDto);
        teams.setSports(sports);
        teams.setSportsName(sports.getSport());
        Teams save = teamsRepository.save(teams);
        TeamsDtoReturn dtoReturn = mapToTeamDtoReturn(save);
        return dtoReturn;
    }



    //Returns all the teams data
    @Override
    public List<TeamsDtoReturn> getAllTeams() {
        List<Teams> allTeams = teamsRepository.findAll();
//        List<TeamsDtoReturn> dtoReturns= new ArrayList<TeamsDtoReturn>();
//        for (int i = 0; i < allTeams.size(); i++) {
//            dtoReturns.add(mapToTeamDtoReturn(allTeams.get(i)));
//        }
         List<TeamsDtoReturn> dtoReturns = allTeams.stream().map(x -> mapToTeamDtoReturn(x)).collect(Collectors.toList());
        return dtoReturns ;

    }

    @Override
    public List<TeamsDtoReturn> getTeamsByCity(String city) {
        List<Teams> byCity = teamsRepository.getByCity(city);

        List<TeamsDtoReturn> collect = byCity.stream().map(x -> mapToTeamDtoReturn(x)).collect(Collectors.toList());
        return collect;
    }


    Teams mapToEntity(TeamDto teamDto){
        Teams teams = new Teams();
        modelMapper.map(teamDto, teams);
        return teams;
    }

    TeamDto mapToDto(Teams teams){
        TeamDto teamDto = new TeamDto();
        modelMapper.map(teams, teamDto);
        return teamDto;
    }
    TeamsDtoReturn mapToTeamDtoReturn(Teams teams){
        System.out.println(teams);
        TeamsDtoReturn dtoReturn = new TeamsDtoReturn();
        dtoReturn.setId(teams.getId());
        dtoReturn.setTeamName(teams.getTeamName());
        dtoReturn.setCity(teams.getCity());
        dtoReturn.setSportsName(teams.getSportsName());
        dtoReturn.setNoOfPlayers(teams.getNoOfPlayers());
        System.out.println(dtoReturn);
//        modelMapper.map(teams, dtoReturn);

        return dtoReturn;
    }
}

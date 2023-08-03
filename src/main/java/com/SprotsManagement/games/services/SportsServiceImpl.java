package com.SprotsManagement.games.services;

import com.SprotsManagement.games.entity.Sports;
import com.SprotsManagement.games.payload.SportsDto;
import com.SprotsManagement.games.repository.SportsRepository;
import com.SprotsManagement.games.services.impl.SportsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportsServiceImpl implements SportsService {

    @Autowired
    private SportsRepository sportsRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public SportsDto addSports(SportsDto sportsDto) {
        Sports sports = mapToEntity(sportsDto);
        Sports save = sportsRepository.save(sports);
        return mapToDto(save);
    }

    @Override
    public List<SportsDto> getAllSports() {
        List<Sports> all = sportsRepository.findAll();
        return  all.stream().map(x -> mapToDto(x)).collect(Collectors.toList());
    }

    Sports mapToEntity(SportsDto sportsDto){
        Sports sports = new Sports();
        modelMapper.map(sportsDto, sports);
        return sports;
    }

    SportsDto mapToDto(Sports sports){
        SportsDto sportsDto = new SportsDto();
        modelMapper.map(sports, sportsDto);
        return sportsDto;
    }
}

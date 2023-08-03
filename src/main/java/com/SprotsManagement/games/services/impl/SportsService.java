package com.SprotsManagement.games.services.impl;

import com.SprotsManagement.games.entity.Sports;
import com.SprotsManagement.games.payload.SportsDto;

import java.util.List;

public interface SportsService {

    SportsDto addSports(SportsDto sportsDto);

    List<SportsDto> getAllSports();
}

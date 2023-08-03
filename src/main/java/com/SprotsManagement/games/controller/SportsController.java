package com.SprotsManagement.games.controller;

import com.SprotsManagement.games.GamesApplication;
import com.SprotsManagement.games.payload.SportsDto;
import com.SprotsManagement.games.services.impl.SportsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class SportsController {

    static Logger logger = LogManager.getLogger(GamesApplication.class);


    @Autowired
    private SportsService sportsService;

    @PostMapping("/add-sports")
    private ResponseEntity<SportsDto> addSports(@RequestBody SportsDto sportsDto){
        return new ResponseEntity<>(sportsService.addSports(sportsDto), HttpStatus.CREATED);
    }

    @GetMapping("/get-sports")
    private ResponseEntity<List<SportsDto>> getSports(){
        return new ResponseEntity<>(sportsService.getAllSports(), HttpStatus.OK);
    }
}

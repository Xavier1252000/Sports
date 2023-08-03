package com.SprotsManagement.games.repository;

import com.SprotsManagement.games.entity.Teams;
import com.SprotsManagement.games.payload.TeamsDtoReturn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamsRepository extends JpaRepository<Teams, Long> {
    List<Teams> getByCity(String city);
}

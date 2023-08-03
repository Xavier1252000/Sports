package com.SprotsManagement.games.repository;

import com.SprotsManagement.games.entity.Sports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsRepository extends JpaRepository<Sports, Long> {
}

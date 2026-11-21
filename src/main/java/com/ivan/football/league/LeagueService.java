package com.ivan.football.league;

import com.ivan.football.common.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LeagueService {
    private final LeagueRepository repository;

    public LeagueService(LeagueRepository repository) {
        this.repository = repository;
    }

    public List<League> findAll() {
        return repository.findAll();
    }

    public League findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("League " + id + " not found"));
    }

    public League create(CreateLeagueRequest request) {
        return repository.save(new League(request.name(), request.country()));
    }
}

package com.ivan.football.league;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LeagueService {
    private final Map<Long, League> leagues = new HashMap<>();

    public LeagueService(){
        leagues.put(1L, new League(1L, "Premier League", "England"));
        leagues.put(2L, new League(2L, "La Liga", "Spain"));
        leagues.put(3L, new League(3L, "Efbet League", "Bulgaria"));
    }

    public List<League> findAll() {
        return new ArrayList<>(leagues.values());
    }

    public Optional<League> findById(Long id) {
        return Optional.ofNullable(leagues.get(id));
    }
}

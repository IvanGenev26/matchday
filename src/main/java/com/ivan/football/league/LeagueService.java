package com.ivan.football.league;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

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

    private final AtomicLong nextId = new AtomicLong(4);

    public League create(CreateLeagueRequest request) {
        Long id = nextId.getAndIncrement();
        League league = new League(id, request.name(), request.country());
        leagues.put(id, league);
        return league;
    }
}

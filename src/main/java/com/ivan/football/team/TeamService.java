package com.ivan.football.team;

import com.ivan.football.league.League;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TeamService {
    private final Map<Long, Team> teams = new LinkedHashMap<>();

    public TeamService() {
        teams.put(1L, new Team(1L, "Arsenal", "London", 1L));
        teams.put(2L, new Team(2L, "Liverpool", "Liverpool", 1L));
        teams.put(3L, new Team(3L, "Barcelona", "Barcelona", 2L));
        teams.put(4L, new Team(3L, "Lokomotiv Plovdiv", "Plovdiv", 3L));
    }

    public List<Team> findAll() {
        return new ArrayList<>(teams.values());
    }

    public List<Team> findByLeagueId(Long leagueId) {
        return teams.values().stream().filter(team -> team.leagueId().equals(leagueId)).toList();
    }

    public Optional<Team> findById(Long id) {
        return Optional.ofNullable(teams.get(id));
    }

    public final AtomicLong nextId = new AtomicLong(5);

    public Team create(CreateTeamRequest request) {
        Long id = nextId.getAndIncrement();
        Team team = new Team(id, request.name(), request.city(), request.leagueId());
        teams.put(id, team);
        return team;
    }
}

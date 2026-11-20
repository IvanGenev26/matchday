package com.ivan.football.player;

import com.ivan.football.common.NotFoundException;
import com.ivan.football.team.TeamService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PlayerService {
    private final Map<Long, Player> players = new LinkedHashMap<>();
    private final AtomicLong nextId = new AtomicLong(4);
    private final TeamService teamService;

    public PlayerService(TeamService teamService) {
        this.teamService = teamService;
        players.put(1L, new Player(1L, "Bukayo Saka", "Forward", 7, 1L));
        players.put(2L, new Player(2L, "Florian Wirtz", "Forward", 7,2L));
        players.put(3L, new Player(3L, "Lamine Yamal", "Forward", 10,3L));
    }

    public List<Player> findAll() {
        return new ArrayList<>(players.values());
    }

    public List<Player> findByTeamId(Long teamId) {
        return players.values().stream().filter(player -> player.teamId().equals(teamId)).toList();
    }

    public Player findById(Long id) {
        return Optional.ofNullable(players.get(id))
                .orElseThrow(() -> new NotFoundException("Player " + id + " not found"));
    }


    public Player create(CreatePlayerRequest request) {
        teamService.findById(request.teamId());
        Long id = nextId.getAndIncrement();
        Player player = new Player(id, request.name(), request.position(), request.shirtNumber(), request.teamId());
        players.put(id, player);
        return player;
    }
}

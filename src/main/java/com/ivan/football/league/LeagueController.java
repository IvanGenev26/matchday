package com.ivan.football.league;

import com.ivan.football.team.Team;
import com.ivan.football.team.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/leagues")
class LeagueController {
    private final LeagueService service;
    private final TeamService teamService;

    public LeagueController(LeagueService service, TeamService teamService) {
        this.service = service;
        this.teamService = teamService;
    }

    @GetMapping
    public List<League> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public League one(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/{id}/teams")
    public List<Team> teams(@PathVariable Long id) {
        service.findById(id);
        return teamService.findByLeagueId(id);
    }

    @PostMapping
    public ResponseEntity<League> create(@Valid @RequestBody CreateLeagueRequest request) {
        League created = service.create(request);
        return ResponseEntity.created(URI.create("/api/leagues/" + created.id())).body(created);
    }
}

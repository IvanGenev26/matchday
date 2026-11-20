package com.ivan.football.team;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
class TeamController {
    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping
    public List<Team> getTeams() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@Valid @RequestBody CreateTeamRequest request) {
        Team created = service.create(request);
        return ResponseEntity.created(URI.create("/api/teams/" + created.id())).body(created);
    }
}

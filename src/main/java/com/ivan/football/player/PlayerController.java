package com.ivan.football.player;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/players")
class PlayerController {
    private final PlayerService service;
    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Player> findAll() {
        return service.findAll();
    }

   @GetMapping("/{id}")
   public Player findById(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player " + id + " not found"));
   }

   @PostMapping
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody CreatePlayerRequest request) {
        Player created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
   }
}

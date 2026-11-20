package com.ivan.football.match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StandingsDemo implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(StandingsDemo.class);
    private final StandingsService standingsService;

    public StandingsDemo(StandingsService standingsService) {
        this.standingsService = standingsService;
    }
    @Override
    public void run(String... args) {
        List<MatchResult> results = List.of(
                new MatchResult(2, 1),
                new MatchResult(1, 1),
                new MatchResult(3, 0)
        );
        log.info("Standings: {}", standingsService.summary("Arsenal", results));
    }
}

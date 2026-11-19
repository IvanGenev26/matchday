package com.ivan.football.match;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupDemo implements CommandLineRunner {
    private final MatchService matchService;

    private StartupDemo(MatchService matchService) {
        this.matchService = matchService;
    }

    @Override
    public void run(String... args) {
        System.out.println(matchService.describe("Levski", "CSKA", 2, 1));
    }
}

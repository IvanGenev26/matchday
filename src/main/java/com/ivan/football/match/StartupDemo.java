package com.ivan.football.match;

import com.ivan.football.config.MatchdayProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupDemo implements CommandLineRunner {
    private final MatchService matchService;
    private final MatchdayProperties props;

    private StartupDemo(MatchService matchService, MatchdayProperties props) {
        this.matchService = matchService;
        this.props = props;
    }

    @Override
    public void run(String... args) {
        System.out.println(matchService.describe("Arsenal", "Liverpool", 2, 1));
        System.out.println(props.defaultLeague() + " " + props.season());
    }
}

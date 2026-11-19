package com.ivan.football.match;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
class StandingsService {
    private final PointsCalculator calculator;

    public StandingsService(@Qualifier("configurablePointsCalculator") PointsCalculator calculator) {
        this.calculator = calculator;
    }

    public String summary (String team, List<MatchResult> results) {
        int total = 0;
        for (MatchResult r : results) {
           total += calculator.points(r.goalsFor(), r.goalsAgainst());
        }
        return team + ": " + total + " pts";
    }


}

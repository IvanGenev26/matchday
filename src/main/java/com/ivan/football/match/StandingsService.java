package com.ivan.football.match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
class StandingsService {
    private static final Logger log = LoggerFactory.getLogger(StandingsService.class);
    private final PointsCalculator calculator;

    public StandingsService(@Qualifier("configurablePointsCalculator") PointsCalculator calculator) {
        this.calculator = calculator;
    }

    public String summary (String team, List<MatchResult> results) {
        int total = 0;
        for (MatchResult r : results) {
            int pts = calculator.points(r.goalsFor(), r.goalsAgainst());
            log.debug("Result {}-{} -> {} pts",r.goalsFor(), r.goalsAgainst(), pts);
            total += pts;
        }
        return team + ": " + total + " pts";
    }


}

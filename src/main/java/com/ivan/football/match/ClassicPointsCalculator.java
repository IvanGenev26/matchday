package com.ivan.football.match;

import org.springframework.stereotype.Component;

@Component
class ClassicPointsCalculator implements PointsCalculator {
    @Override
    public int points(int goalsFor, int goalsAgainst) {
        if (goalsFor > goalsAgainst) {
            return 2;
        } else if (goalsFor == goalsAgainst) {
            return 1;
        } else {
            return 0;
        }
    }
}

package com.ivan.football.match;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
class ModernPointsCalculator implements PointsCalculator {
    @Override
    public int points(int goalsFor, int goalsAgainst) {
        if (goalsFor > goalsAgainst) {
            return 3;
        } else if (goalsFor == goalsAgainst) {
            return 1;
        } else {
            return 0;
        }
    }
}

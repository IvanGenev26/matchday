package com.ivan.football.match;

import com.ivan.football.config.PointsProperties;
import org.springframework.stereotype.Component;

@Component
public class ConfigurablePointsCalculator implements PointsCalculator {
    private final PointsProperties properties;

    public ConfigurablePointsCalculator(PointsProperties properties) {
        this.properties = properties;
    }
    @Override
    public int points(int goalsFor, int goalsAgainst) {
        if (goalsFor > goalsAgainst) {
            return properties.win();
        } else if (goalsFor == goalsAgainst) {
            return properties.draw();
        } else {
            return properties.loss();
        }
    }
}

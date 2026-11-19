package com.ivan.football.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "matchday.points")
public record PointsProperties(int win, int loss, int draw) {

}

package com.ivan.football.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "matchday")
public record MatchdayProperties(String defaultLeague, String season) {

}

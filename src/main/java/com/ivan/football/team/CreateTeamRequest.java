package com.ivan.football.team;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTeamRequest(@NotBlank String name, @NotBlank String city, @NotNull Long leagueId) {
}

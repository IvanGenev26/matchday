package com.ivan.football.player;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePlayerRequest(@NotBlank String name, @NotBlank String position, @NotNull Integer shirtNumber, @NotNull Long teamId) {
}

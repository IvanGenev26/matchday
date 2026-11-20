package com.ivan.football.league;

import jakarta.validation.constraints.NotBlank;

public record CreateLeagueRequest (@NotBlank String name, @NotBlank String country){}

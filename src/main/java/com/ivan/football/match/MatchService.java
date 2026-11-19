package com.ivan.football.match;

import org.springframework.stereotype.Service;

@Service
public class MatchService {
    private final ScoreFormatter formatter;

    public MatchService(ScoreFormatter formatter) {
        this.formatter = formatter;
    }

    public String describe(String home, String away, int h, int a) {
        return home + " " + formatter.format(h, a) + " " + away;
    }
}

package com.ivan.football.match;


import org.springframework.stereotype.Component;

@Component
public class DashScoreFormatter implements ScoreFormatter {
    @Override
    public String format(int home, int away) {
        return home + " - " + away;
    }

}

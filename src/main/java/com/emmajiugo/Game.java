package com.emmajiugo;

import java.time.Instant;
import lombok.Data;

@Data
public class Game {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private Long createdAt;

    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.createdAt = Instant.now().getEpochSecond();
    }

    public void updateScores(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    @Override
    public String toString() {
        return homeTeam + " " + homeScore + " - " + awayScore + " " + awayTeam;
    }
}

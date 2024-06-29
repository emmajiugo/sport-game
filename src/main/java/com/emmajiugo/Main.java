package com.emmajiugo;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ScoreBoard scoreboard = new ScoreBoard();

        String homeTeam, awayTeam;

        // Match 1
        homeTeam = "Mexico";
        awayTeam = "Canada";
        scoreboard.startGame(homeTeam, awayTeam);
        scoreboard.updateScore(homeTeam, awayTeam, 0, 5);
        scoreboard.finishGame(homeTeam, awayTeam);

        // Match 2
        homeTeam = "Spain";
        awayTeam = "Brazil";
        scoreboard.startGame(homeTeam, awayTeam);
        scoreboard.updateScore(homeTeam, awayTeam, 10, 2);
        scoreboard.finishGame(homeTeam, awayTeam);

        // Match 3
        homeTeam = "Germany";
        awayTeam = "France";
        scoreboard.startGame(homeTeam, awayTeam);
        scoreboard.updateScore(homeTeam, awayTeam, 2, 2);
        scoreboard.finishGame(homeTeam, awayTeam);

        // Match 4
        homeTeam = "Uruguay";
        awayTeam = "Italy";
        scoreboard.startGame(homeTeam, awayTeam);
        scoreboard.updateScore(homeTeam, awayTeam, 6, 6);
        scoreboard.finishGame(homeTeam, awayTeam);

        // Match 5
        homeTeam = "Argentina";
        awayTeam = "Australia";
        scoreboard.startGame(homeTeam, awayTeam);
        scoreboard.updateScore(homeTeam, awayTeam, 3, 1);
        scoreboard.finishGame(homeTeam, awayTeam);

        // Get game summary
        List<Game> summary = scoreboard.getSummaryByTotalScore();
        for (int i = 0; i < summary.size(); i++) {
            System.out.println((i + 1) + ". " + summary.get(i));
        }

    }
}

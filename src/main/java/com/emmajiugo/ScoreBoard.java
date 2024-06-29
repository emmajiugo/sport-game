package com.emmajiugo;

import java.util.*;

public class ScoreBoard {
    private Map<String, Game> games = new HashMap<>();
    private Map<String, Game> gameSummary = new HashMap<>();

    public void startGame(String homeTeam, String awayTeam) {
        String key = gameKey(homeTeam, awayTeam);
        games.put(key, new Game(homeTeam, awayTeam));
    }

    public void finishGame(String homeTeam, String awayTeam) throws Exception {
        String key = gameKey(homeTeam, awayTeam);

        // add game to gameSummary
        Game game = games.get(key);
        if (game != null) {
            gameSummary.put(key, game);
        } else {
            throw new Exception("Game not found");
        }
        
        games.remove(key);
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) throws Exception {
        String key = gameKey(homeTeam, awayTeam);
        Game game = games.get(key);
        if (game != null) {
            game.updateScores(homeScore, awayScore);
        } else {
            throw new Exception("Game not found");
        }
    }

    public List<Game> getSummaryByTotalScore() {
        List<Game> sortedGames = new ArrayList<>(gameSummary.values());

        // Sort by total score
        sortedGames.sort(Comparator.comparingInt(game -> game.getHomeScore() + game.getAwayScore()));

        // Then sort by timestamp
        sortedGames.sort(Comparator.comparingLong(Game::getCreatedAt));

        Collections.reverse(sortedGames);

        return sortedGames;
    }

    private String gameKey(String team1, String team2) {
        return team1 + "-" + team2;
    }
}

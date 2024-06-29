package com.emmajiugo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

public class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    @BeforeEach
    public void setUp() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    public void testStartGameUpdateScoreFinishGame() throws Exception {
        scoreBoard.startGame("Nigeria", "Spain");
        scoreBoard.updateScore("Nigeria", "Spain", 3, 2);
        scoreBoard.finishGame("Nigeria", "Spain");

        List<Game> summary = scoreBoard.getSummaryByTotalScore();
        assertEquals(1, summary.size());

        Game game = summary.get(0);
        assertEquals("Nigeria", game.getHomeTeam());
        assertEquals("Spain", game.getAwayTeam());
        assertEquals(3, game.getHomeScore());
        assertEquals(2, game.getAwayScore());
    }

    @Test
    public void testStartGameFinishGameWithoutUpdatingScore() throws Exception {
        scoreBoard.startGame("Nigeria", "Spain");
        scoreBoard.finishGame("Nigeria", "Spain");

        List<Game> summary = scoreBoard.getSummaryByTotalScore();
        assertEquals(1, summary.size());

        Game game = summary.get(0);
        assertEquals("Nigeria", game.getHomeTeam());
        assertEquals("Spain", game.getAwayTeam());
        assertEquals(0, game.getHomeScore());
        assertEquals(0, game.getAwayScore());
    }

    @Test
    public void testUpdateScoreForNonStartedGame() throws Exception {
        Exception exception = assertThrows(Exception.class,
                () -> scoreBoard.updateScore("Mexico", "Brazil", 3, 2));

        assertEquals("Game not found", exception.getMessage());
    }
    
    @Test
    public void testFinishGameForNonStartedGame() throws Exception {
        Exception exception = assertThrows(Exception.class,
                () -> scoreBoard.finishGame("Mexico", "Brazil"));

        assertEquals("Game not found", exception.getMessage());
    }
}
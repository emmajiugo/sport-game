package com.emmajiugo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testGameSetup() {
        Game game = new Game("Nigeria", "Spain");

        assertEquals(game.getHomeTeam(), "Nigeria");
        assertEquals(game.getAwayTeam(), "Spain");
    }

    @Test
    public void testUpdateScores() {
        Game game = new Game("Nigeria", "Spain");
        game.updateScores(3, 2);

        assertEquals(3, game.getHomeScore());
        assertEquals(2, game.getAwayScore());
    }

    @Test
    public void testToString() {
        Game game = new Game("Nigeria", "Spain");
        game.updateScores(3, 2);

        String expected = "Nigeria 3 - 2 Spain";
        assertEquals(expected, game.toString());
    }
}
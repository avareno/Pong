package com.mlg.pong.model;

import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.game.arena.ClassicGameBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaTest {
    private ClassicGameBuilder builder;
    private ClassicGame game;

    @BeforeEach
    void setUp() {
        builder = new ClassicGameBuilder();
        game = builder.createClassicGame();
    }

    @Test
    void PositionWall() {
        for (int i = 0;i < builder.getWidth(); i++ ) {
            assertEquals(false,game.isEmpty(new Position(i,0),0));
            assertEquals(false,game.isEmpty(new Position(i,builder.getHeight()-1),0));
        }
    }

    @Test
    void PositionEmpty() {
        assertEquals(true,game.isEmpty(new Position(0,1),0));
    }
}

package com.mlg.pong.controller;

import com.mlg.pong.controller.game.PlayerController;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.game.arena.ClassicGameBuilder;
import com.mlg.pong.model.game.elements.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerMoveTest {
    private PlayerController controller;
    private ClassicGameBuilder builder;
    private ClassicGame game;
    private List<Position> initial;
    private List<Position> max;
    private List<Position> min;

    @BeforeEach
    void setUp() {
        builder = new ClassicGameBuilder();
        game = builder.createClassicGame();
        controller = new PlayerController(game);
        initial = new ArrayList<>();
        for (Player p : game.getPlayer1()) {
            initial.add(p.getPosition());
        }
        max = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            max.add(new Position(0,i));
        }
        min = new ArrayList<>();
        for (int i = builder.getHeight()- 7; i < builder.getHeight() - 1; i++) {
            min.add(new Position(0,i));
        }
    }

    @Test
    void movePlayerUpEmpty() {
        controller.movePlayerUp();
        for (int i = 0;i < 6; i++) {
            Position UP = new Position(initial.get(i).getX(),initial.get(i).getY()-1);
            Assertions.assertEquals(UP, game.getPlayer1().get(i).getPosition());
        }
    }

    @Test
    void movePlayerUpWall() {
        while(!game.getPlayer1().get(0).getPosition().equals(max.get(0))) { // Reach Max Height
            controller.movePlayerUp();
        }
        controller.movePlayerUp(); // Attempt to move up while at max height

        for (int i = 0; i < 6; i++) {
            Position P = max.get(i);
            Assertions.assertEquals(P,game.getPlayer1().get(i).getPosition());
        }
    }

    @Test
    void movePlayerDownEmpty() {
        controller.movePlayerDown();
        for (int i = 0;i < 6; i++) {
            Position DOWN = new Position(initial.get(i).getX(),initial.get(i).getY()+1);
            Assertions.assertEquals(DOWN, game.getPlayer1().get(i).getPosition());
        }
    }

    @Test
    void movePlayerDownWall() {
        while(!game.getPlayer1().get(0).getPosition().equals(min.get(0))) { // Reach Min Height
            controller.movePlayerDown();
        }

        controller.movePlayerDown(); // Attempt to move down while at min height

        for (int i = 0; i < 6; i++) {
            Position P = min.get(i);
            Assertions.assertEquals(P,game.getPlayer1().get(i).getPosition());
        }
    }
}

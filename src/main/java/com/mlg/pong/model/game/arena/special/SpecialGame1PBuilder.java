package com.mlg.pong.model.game.arena.special;

import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.classic.ClassicGame1PBuilder;
import com.mlg.pong.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class SpecialGame1PBuilder extends ClassicGame1PBuilder {

    private int difficulty;

    public SpecialGame1PBuilder(int difficulty) {
        super(difficulty);
    }
    protected PowerUP createPowerUP(){
        PowerUP powerup = new PowerUP(1,1);
        powerup.Consume();
        return powerup;
    }
    public ClassicGame createSpecialGame() {
        ClassicGame cgame = new ClassicGame(getWidth(), getHeight());
        cgame.setPlayer1(super.createPlayer());
        cgame.setPlayer2(createPlayer());
        cgame.setWalls(createWalls());
        cgame.setBall(createBall());
        cgame.setPowerUP(createPowerUP());
        cgame.setPoint1(0);
        cgame.setPoints2(0);
        return cgame;
    }
}

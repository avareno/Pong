package com.mlg.pong.model.game.arena.special;

import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.classic.ClassicGame2PBuilder;
import com.mlg.pong.model.game.elements.*;

public class SpecialGame2PBuilder extends ClassicGame2PBuilder {

    public SpecialGame2PBuilder() {
        super();
    }
    protected PowerUP createPowerUP(){
        PowerUP powerup = new PowerUP(1,1);
        powerup.Consume();
        return powerup;
    }
    @Override
    public SpecialGame createGame() {
        SpecialGame cgame = new SpecialGame(getWidth(), getHeight());
        ClassicGame classicGame = super.createGame();
        cgame.setPlayer1(classicGame.getPlayer1());
        cgame.setPlayer2(classicGame.getPlayer2());
        cgame.setWalls(classicGame.getWalls());
        cgame.setBall(classicGame.getBall());
        cgame.setPowerup(createPowerUP());
        return cgame;
    }
}

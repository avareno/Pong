package com.mlg.pong.model.game.arena.special;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.classic.ClassicGame1PBuilder;
import com.mlg.pong.model.game.elements.*;

public class SpecialGame1PBuilder extends ClassicGame1PBuilder {

    private int difficulty;

    public SpecialGame1PBuilder(int difficulty) {
        super(difficulty);
        this.difficulty = difficulty;

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
        cgame.setDifficulty(difficulty);
        return cgame;
    }
}

package com.mlg.pong.model.game.arena.special;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.classic.ClassicGame1PBuilder;
import com.mlg.pong.model.game.elements.*;

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
        SpecialGame cgame = new SpecialGame(getWidth(), getHeight());
        super.createClassicGame();
        cgame.setPowerup(createPowerUP());
        return cgame;
    }
}

package com.mlg.pong.model.game.arena.special;

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
    public SpecialGame createSpecialGame() {
        SpecialGame sgame = new SpecialGame(getWidth(), getHeight());
        super.createClassicGame();
        sgame.setPowerup(createPowerUP());
        return sgame;
    }
}

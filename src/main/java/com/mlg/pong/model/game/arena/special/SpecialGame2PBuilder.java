package com.mlg.pong.model.game.arena.special;

import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.classic.ClassicGame2PBuilder;
import com.mlg.pong.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class SpecialGame2PBuilder extends ClassicGame2PBuilder {

    public SpecialGame2PBuilder() {
        super();
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

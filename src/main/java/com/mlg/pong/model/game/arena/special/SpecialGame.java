package com.mlg.pong.model.game.arena.special;

import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.elements.PowerUP;

public class SpecialGame extends ClassicGame {
    private PowerUP powerup;


    public PowerUP getPowerup() {
        return powerup;
    }

    public void setPowerup(PowerUP powerup) {
        this.powerup = powerup;
    }

    public SpecialGame(int width, int height) {
        super(width, height);
    }
}

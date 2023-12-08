package com.mlg.pong.viewer.game;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.elements.PowerUP;

public class PowerUpViewer implements ElementViewer<PowerUP> {
    @Override
    public void draw(PowerUP powerup, GUI gui) {gui.drawPowerUp(powerup.getPosition());}
}

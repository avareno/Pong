package com.mlg.pong.viewer.game.special;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.classic.ClassicGame1PBuilder;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.viewer.game.PowerUpViewer;
import com.mlg.pong.viewer.game.classic.ClassicGame1PViewer;

public class SpecialGame1PViewer extends ClassicGame1PViewer {

    public SpecialGame1PViewer(SpecialGame sgame) {
        super(sgame);
    }

    @Override
    public SpecialGame getModel() {
        return (SpecialGame) super.getModel();
    }

    @Override
    public void drawElements(GUI gui) {
        super.drawElements(gui);
        if(getModel().getPowerup() != null) {
            if (!getModel().getPowerup().isConsumed()) {
                drawElement(gui, getModel().getPowerup(), new PowerUpViewer());
            }
        }
    }
}

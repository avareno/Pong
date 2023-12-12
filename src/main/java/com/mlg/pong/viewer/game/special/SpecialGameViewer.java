package com.mlg.pong.viewer.game.special;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.model.game.elements.Element;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.game.*;

import java.util.List;

public class SpecialGameViewer extends Viewer<SpecialGame> {

    public SpecialGameViewer(SpecialGame sgame) {
        super(sgame);
    }

    @Override
    public SpecialGame getModel() {
        return (SpecialGame) super.getModel();
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui,getModel().getPlayer1(), new PlayerViewer());
        drawElement(gui,getModel().getPlayer2(), new PlayerViewer());
        drawElement(gui, getModel().getBall(), new BallViewer());
        gui.drawText(new Position(getModel().getWidth()/2-1,2), Integer.toString(getModel().getPoints1()) + "-" + Integer.toString(getModel().getPoints2()),"#FFFFFF");

        if(getModel().getPowerup() != null) {
            if (!getModel().getPowerup().isConsumed()) {
                drawElement(gui, getModel().getPowerup(), new PowerUpViewer());
            }
        }
    }

    protected <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    protected <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}

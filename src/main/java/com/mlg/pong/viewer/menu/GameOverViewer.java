package com.mlg.pong.viewer.menu;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.menu.GameOver;
import com.mlg.pong.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(25, 15), (getModel().getWhoWon() + " Won!"), "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(25, 17 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#00ffd4" : "#FFFFFF");
    }
}
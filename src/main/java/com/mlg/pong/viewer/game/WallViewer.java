package com.mlg.pong.viewer.game;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.elements.Walls;

public class WallViewer implements ElementViewer<Walls> {
    @Override
    public void draw(Walls wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}

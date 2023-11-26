package com.aor.pong.viewer.game;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.elements.Walls;

public class WallViewer implements ElementViewer<Walls> {
    @Override
    public void draw(Walls wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}

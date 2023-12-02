package com.mlg.pong.viewer.game;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.elements.Computer;

public class ComputerViewer implements ElementViewer<Computer>{
    @Override
    public void draw(Computer computer, GUI gui) {
        gui.drawPlayer(computer.getPosition());
    }
}

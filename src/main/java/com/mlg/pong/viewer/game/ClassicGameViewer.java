package com.mlg.pong.viewer.game;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.game.elements.Computer;
import com.mlg.pong.model.game.elements.Element;
import com.mlg.pong.model.game.elements.Player;
import com.mlg.pong.viewer.Viewer;

import java.util.List;

public class    ClassicGameViewer extends Viewer<ClassicGame> {

    public ClassicGameViewer(ClassicGame cgame) {
        super(cgame);
    }

    @Override
    public ClassicGame getModel() {
        return super.getModel();
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui,getModel().getPlayer1(), new PlayerViewer());
        drawElement(gui,getModel().getComputer(), new ComputerViewer());
        drawElement(gui, getModel().getBall(), new BallViewer());
        if (!getModel().getPowerup().isConsumed()) {
            drawElement(gui,getModel().getPowerup(), new PowerUpViewer());
        }
    }

    private void drawElement(GUI gui, List<Computer> player2, ComputerViewer computerViewer) {
        for(Computer at: player2){
            drawElement(gui, at, computerViewer);
        }
    }

    private void drawElement(GUI gui, List<Player> player1, PlayerViewer playerViewer) {
        for(Player at: player1){
            drawElement(gui, at, playerViewer);
        }
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}

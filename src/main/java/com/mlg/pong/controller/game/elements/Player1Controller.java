package com.mlg.pong.controller.game.elements;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.menu.GameOver;
import com.mlg.pong.states.GameOverState;

public class Player1Controller extends Controller {
    private ClassicGame model = (ClassicGame) getModel();
    public Player1Controller(ClassicGame cgame) {
        super(cgame);
    }


    public void movePlayerUp() {
        movePlayer(model.getPlayer1().getPlayersPositions().get(0),-1);
    }
    public void movePlayerDown() {
        movePlayer(model.getPlayer1().getPlayersPositions().get(model.getPlayer1().getPlayersPositions().size()-1),1) ;
    }

    public void movePlayer(Position position, int i) {
        if (model.isEmpty(new Position(position.getX(),position.getY()+i))) {
            model.getPlayer1().setPosition(new Position(model.getPlayer1().getPosition().getX(),model.getPlayer1().getPosition().getY()+i));
        }
    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) {
        if (this.model.getPoints1() >= 10) app.setState(new GameOverState(new GameOver("Player 1")));
        if (action == GUI.ACTION.UP) movePlayerUp();
        if (action == GUI.ACTION.DOWN) movePlayerDown();
    }
}

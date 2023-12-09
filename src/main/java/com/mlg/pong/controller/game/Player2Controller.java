package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.ClassicGame;

public class Player2Controller extends Controller {
    private ClassicGame model = (ClassicGame) getModel();
    public Player2Controller(ClassicGame cgame) {
        super(cgame);
    }
    public void movePlayerUp() {
        movePlayer(model.getPlayer2().getPlayersPositions().get(0),-1);
    }
    public void movePlayerDown() {
        movePlayer(model.getPlayer2().getPlayersPositions().get(model.getPlayer2().getPlayersPositions().size()-1),1) ;
    }
    public void movePlayer(Position position, int i) {
        if (model.isEmpty(new Position(position.getX(),position.getY()+i),1)) {
            model.getPlayer2().setPosition(new Position(model.getPlayer2().getPosition().getX(),model.getPlayer2().getPosition().getY()+i));
        }
    }
    @Override
    public void step(Application app, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.P2UP) movePlayerUp();
        if (action == GUI.ACTION.P2DOWN) movePlayerDown();
    }
}

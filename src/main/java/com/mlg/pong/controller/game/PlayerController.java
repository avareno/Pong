package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.game.elements.Player;

public class PlayerController extends Controller {
    private ClassicGame model = (ClassicGame) getModel();
    public PlayerController(ClassicGame cgame) {
        super(cgame);
    }


    public void movePlayer1Up() {

        movePlayer(model.getPlayer1().get(0).getPosition(),-1);
    }

    public void movePlayerDown() {
        movePlayer(model.getPlayer1().get(model.getPlayer1().size()-1).getPosition(),1);
    }

    private void movePlayer(Position position, int i) {
        if (model.isEmpty(new Position(position.getX(),position.getY()+i))) {
            for(Player at: model.getPlayer1()){
                at.setPosition(new Position(at.getPosition().getX(),at.getPosition().getY()+i));
            }
        }
    }


    @Override
    public void step(Application app, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePlayer1Up();
        if (action == GUI.ACTION.DOWN) movePlayerDown();
    }
}

package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.game.elements.Player;

public class Player2Controller extends Controller {
    private ClassicGame model = (ClassicGame) getModel();
    public Player2Controller(ClassicGame cgame) {
        super(cgame);
    }


    public void movePlayerUp() {

        int speed = model.getComputer().getSpeed();

        if((model.getComputer().getPosition().getY() - model.getComputer().getSpeed()) <= 1) speed = (- (model.getComputer().getPosition().getY()) + 2) * -1;

        if(speed < 0) speed  =0;

        movePlayer(model.getComputer(),-speed);
    }

    public void movePlayerDown() {
        int speed = model.getComputer().getSpeed();

        if((model.getHeight()-(model.getComputer().getPosition().getY() + model.getComputer().getSize() + model.getComputer().getSpeed())) <= 0) speed = (model.getHeight() - (model.getComputer().getPosition().getY() + model.getComputer().getSize())) ;

        if(speed < 0) speed  =0;
        movePlayer(model.getComputer(),speed);
    }

    public void movePlayer(Player player, int i) {
        if (model.isEmpty(new Position(player.getPosition().getX(),player.getPosition().getY()+i),0,"player")) {
            Player at = model.getComputer();
                at.setPosition(new Position(at.getPosition().getX(),at.getPosition().getY()+i));

        }
    }
    
    @Override
    public void step(Application app, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.P2UP) movePlayerUp();
        if (action == GUI.ACTION.P2DOWN) movePlayerDown();
    }
}

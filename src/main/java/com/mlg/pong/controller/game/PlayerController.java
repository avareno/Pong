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


    public void movePlayerUp() {
        int speed = model.getPlayer1().getSpeed();

        if((model.getPlayer1().getPosition().getY() - model.getPlayer1().getSpeed()) <= 1) speed = (- (model.getPlayer1().getPosition().getY()) + 2) * -1;

        if(speed < 0) speed  =0;

        movePlayer(model.getPlayer1(),-speed);
    }

    public void movePlayerDown() {
        int speed = model.getPlayer1().getSpeed();

        if((model.getHeight()-(model.getPlayer1().getPosition().getY() + model.getPlayer1().getSize() + model.getPlayer1().getSpeed())) <= 0) speed = (model.getHeight() - (model.getPlayer1().getPosition().getY() + model.getPlayer1().getSize())) ;

        if(speed < 0) speed  =0;
        movePlayer(model.getPlayer1(),speed);
    }

    public void movePlayer(Player player, int i) {
        Position pos = new Position(player.getPosition().getX(),player.getPosition().getY()+i);
        if (model.isEmpty(pos,0,"player")) {
            player.setPosition(pos);
        }
    }


    @Override
    public void step(Application app, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePlayerUp();
        if (action == GUI.ACTION.DOWN) movePlayerDown();
    }
}

package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.game.elements.Ball;
import com.mlg.pong.model.game.elements.Computer;

import java.io.IOException;

public class ComputerController extends Controller {
    private ClassicGame model = (ClassicGame) getModel();
    private long lastMovement;

    public ComputerController(ClassicGame cgame) {
        super(cgame);
        this.lastMovement=0;
    }

    public int calculatePosition(Ball ball){
        int res=ball.getPosition().getX(),res1=ball.getPosition().getY();
        while(res!=model.getWidth()-1){
            res += ball.getVector().getP().getX();
            res1+= ball.getVector().getP().getY();
        }
        if(res1>model.getComputer().get(2).getPosition().getY()){
            return 1;
        }else {
            return -1;
        }
    }

    public void moveComputer(){

        if (model.isEmpty(new Position(model.getComputer().get(2).getPosition().getX(),model.getComputer().get(2).getPosition().getY()+calculatePosition(model.getBall())))) {
            for(Computer at: model.getComputer()){
                at.setPosition(new Position(at.getPosition().getX(),at.getPosition().getY()+calculatePosition(model.getBall())));
            }
        }

    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        if(time-this.lastMovement>50) {
            moveComputer();
            this.lastMovement=time;
        }
    }
}

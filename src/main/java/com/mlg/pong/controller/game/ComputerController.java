package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.game.elements.Ball;
import com.mlg.pong.model.game.elements.Computer;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ComputerController extends Controller {

    private ClassicGame model = (ClassicGame) getModel();
    private ScheduledExecutorService executor;

    public void startMovementComputer() {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(this::moveComputer, 0, 1, TimeUnit.SECONDS);
    }

    public ComputerController(ClassicGame cgame) {
        super(cgame);
        startMovementComputer();
    }

    public int calculatePosition(Ball ball){
        int res=ball.getPosition().getX(),res1=ball.getPosition().getY();
        while(res!=model.getWidth()-1){
            res += ball.getVector().getP().getX();
            res1+= ball.getVector().getP().getY();
        }
        if(res1>model.getPlayer2().get(2).getPosition().getY()){
            return 1;
        }else {
            return -1;
        }
    }

    public void moveComputer(){

        if (model.isEmpty(new Position(model.getPlayer2().get(2).getPosition().getX(),model.getPlayer2().get(2).getPosition().getY()+calculatePosition(model.getBall())))) {
            for(Computer at: model.getPlayer2()){
                at.setPosition(new Position(at.getPosition().getX(),at.getPosition().getY()+calculatePosition(model.getBall())));
            }
        }

    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        moveComputer();
    }
}

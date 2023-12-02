package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.game.elements.Ball;
import com.mlg.pong.model.game.elements.Player;
import com.mlg.pong.model.game.elements.Vector;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class BallController extends Controller {
    private ClassicGame model = (ClassicGame) getModel();
    private ScheduledExecutorService executor;
    public BallController(ClassicGame cgame){
        super(cgame);
        startBallMovement();
    }

    public void startBallMovement() {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(this::moveBall, 0, 2, TimeUnit.SECONDS);
    }
    public void moveBall(){
        if(model.getBall().getPosition().getX()==0 || model.getBall().getPosition().getX()==model.getWidth()-1){
            model.setBall(model.getWidth()/2,model.getHeight()/2);
        }
        if (model.isEmpty(new Position(model.getBall().getPosition().getX()+model.getBall().getVector().getP().getX(),model.getBall().getPosition().getY()+model.getBall().getVector().getP().getY()))) {
            model.setBall(new Ball(model.getBall().getPosition().getX()+model.getBall().getVector().getP().getX(),model.getBall().getPosition().getY()+model.getBall().getVector().getP().getY(),model.getBall().getVector()));
        }else{
            if(model.isPlayer(new Position(model.getBall().getPosition().getX()+model.getBall().getVector().getP().getX(),model.getBall().getPosition().getY()+model.getBall().getVector().getP().getY()))) {
                model.setBall(new Ball(model.getBall().getPosition().getX(), model.getBall().getPosition().getY(), model.getBall().invertVector(1)));
            }else if(model.isWall(new Position(model.getBall().getPosition().getX()+model.getBall().getVector().getP().getX(),model.getBall().getPosition().getY()+model.getBall().getVector().getP().getY()))){
                model.setBall(new Ball(model.getBall().getPosition().getX(), model.getBall().getPosition().getY(), model.getBall().invertVector(0)));
            }
        }

    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) {
        moveBall();
    }
}

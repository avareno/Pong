package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.game.elements.Ball;

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

    private void startBallMovement() {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(this::moveBall, 0, 2, TimeUnit.SECONDS);
    }
    public void moveBall(){
        model.setBall(new Ball(model.getBall().getPosition().getX()+model.getBall().getVector().getP().getX(),model.getBall().getPosition().getY()+model.getBall().getVector().getP().getY()));

    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) {
        moveBall();
    }
}

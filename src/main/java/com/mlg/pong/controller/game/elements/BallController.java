package com.mlg.pong.controller.game.elements;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.elements.Ball;

public class BallController extends Controller {
    private ClassicGame model = (ClassicGame) getModel();
    private long lastMovement;
    public BallController(ClassicGame cgame){
        super(cgame);
        this.lastMovement=0;
    }


    public void moveBall() {
        if (model.getBall().getPosition().getX() == 0 || model.getBall().getPosition().getX() == model.getWidth() - 1) {
            if (model.getBall().getPosition().getX() == 0) {
                model.addPoints2();
            } else {
                model.addPoints1();
            }
            model.setBall(model.getWidth() / 2, model.getHeight() / 2);
        } else {
            Position newPosition = new Position(model.getBall().getPosition().getX() + model.getBall().getVector().getP().getX(),model.getBall().getPosition().getY() + model.getBall().getVector().getP().getY());
            Ball newBall = new Ball(newPosition.getX(), newPosition.getY(), model.getBall().getVector());

            model.setBall(
                    model.isEmpty(newPosition)
                            ? newBall
                            : new Ball(
                            model.getBall().getPosition().getX(),
                            model.getBall().getPosition().getY(),
                            model.isWall(newPosition)
                                    ? model.getBall().invertVector(0)
                                    : model.getBall().invertVector(1)
                    )
            );
        }
    }




    @Override
    public void step(Application app, GUI.ACTION action, long time) {
        if (time - lastMovement > 100) {
            moveBall();
            lastMovement = time;
        }

    }
}

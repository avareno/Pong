package com.mlg.pong.viewer.game;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.elements.Ball;

public class BallViewer implements ElementViewer<Ball>{
    @Override
    public void draw(Ball ball, GUI gui) {
        gui.drawBall(ball.getPosition());
    }
}

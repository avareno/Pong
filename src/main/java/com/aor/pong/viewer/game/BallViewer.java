package com.aor.pong.viewer.game;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.elements.Ball;

public class BallViewer implements ElementViewer<Ball>{
    @Override
    public void draw(Ball ball, GUI gui) {
        gui.drawBall(ball.getPosition());
    }
}

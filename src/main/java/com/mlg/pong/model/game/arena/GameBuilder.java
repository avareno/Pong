package com.mlg.pong.model.game.arena;

import com.mlg.pong.model.game.elements.Ball;
import com.mlg.pong.model.game.elements.Player;
import com.mlg.pong.model.game.elements.Walls;

import java.util.ArrayList;
import java.util.List;

public abstract class GameBuilder {

    public GameBuilder() {
        this.width = 70;
        this.height = 30;
    }

    int height ,width;

    protected Ball createBall(){
        return new Ball(width/2,height/2);
    }
    protected List<Walls> createWalls(){
        List<Walls> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Walls(c, 0));
            walls.add(new Walls(c, height - 1));
        }
        return walls;
    }

    protected Player createPlayer(){
        return new Player(1, (height / 2));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

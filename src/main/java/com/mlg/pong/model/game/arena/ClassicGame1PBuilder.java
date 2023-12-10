package com.mlg.pong.model.game.arena;
import com.mlg.pong.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class ClassicGame1PBuilder {
    public ClassicGame1PBuilder() {
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

    protected Computer createComputer(){
        return new Computer(width-2, (height/2));
    }

    protected Player createPlayer(){
        return new Player(1, (height / 2));
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ClassicGame createClassicGame() {
        ClassicGame cgame = new ClassicGame(getWidth(), getHeight());
        cgame.setPlayer1(createPlayer());
        cgame.setComputer(createComputer());
        cgame.setWalls(createWalls());
        cgame.setBall(createBall());
        cgame.setPoint1(0);
        cgame.setPoints2(0);
        return cgame;
    }
}

package com.mlg.pong.model.game.arena;

import com.mlg.pong.model.game.elements.Ball;
import com.mlg.pong.model.game.elements.Computer;
import com.mlg.pong.model.game.elements.Player;
import com.mlg.pong.model.game.elements.Walls;

import java.util.ArrayList;
import java.util.List;

public class ClassicGame2PBuilder {
    public ClassicGame2PBuilder() {
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

    protected Player createPlayers(int i){
        if(i==0)return new Player(1, (height / 2));
        else return new Player(width-2,(height / 2));
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
        cgame.setPlayer1(createPlayers(0));
        cgame.setPlayer2(createPlayers(1));
        cgame.setWalls(createWalls());
        cgame.setBall(createBall());
        cgame.setPoint1(0);
        cgame.setPoints2(0);
        return cgame;
    }
}

package com.mlg.pong.model.game.arena;

import com.googlecode.lanterna.screen.Screen;
import com.mlg.pong.Application;
import com.mlg.pong.model.game.elements.Computer;
import com.mlg.pong.model.game.elements.Player;
import com.mlg.pong.model.game.elements.Walls;
import com.mlg.pong.model.game.elements.Ball;

import java.util.ArrayList;
import java.util.List;

public class ClassicGameBuilder {

    public ClassicGameBuilder(Application app) {
        //int value = (int) (app.getWidth() / 5.83);
        this.width = app.getWidth() - 12;
        this.height = app.getHeight();
    }

    int height ,width;

    protected Ball createBall(){
        return new Ball(width/2,height/2,0,0);
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
        Computer computer = null;

            computer = new Computer(width-1, (height/2)-5,6,1);

        return computer;
    }

    protected Player createPlayers(){
        Player player = null;

        player = new Player(0, (height/2)-5,6,1);


        return player;
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
            cgame.setPlayer1(createPlayers());
            cgame.setComputer(createComputer());
            cgame.setWalls(createWalls());
            cgame.setBall(createBall());
            cgame.setPoint1(0);
            cgame.setPoints2(0);

            return cgame;
    }


}

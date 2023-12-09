package com.mlg.pong.model.game.arena;

import com.mlg.pong.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class SpecialGameBuilder {

    public SpecialGameBuilder() {
        //int value = (int) (app.getWidth() / 5.83);
        this.width = 58;     // Esta parte estava a dar conflitos com o MenuController
        this.height = 30;    // e não tenho a certeza qual seria a diferença entre usar os valores
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

    protected PowerUP createPowerUP(){
        PowerUP powerup = new PowerUP(1,1,0,0);
        powerup.Consume();
        return powerup;
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


    public ClassicGame createSpecialGame() {
            ClassicGame cgame = new ClassicGame(getWidth(), getHeight());
            cgame.setPlayer1(createPlayers());
            cgame.setComputer(createComputer());
            cgame.setWalls(createWalls());
            cgame.setBall(createBall());
            cgame.setPowerUP(createPowerUP());
            cgame.setPoint1(0);
            cgame.setPoints2(0);


            return cgame;
    }


}

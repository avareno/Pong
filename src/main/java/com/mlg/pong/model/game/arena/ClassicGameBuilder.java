package com.mlg.pong.model.game.arena;

import com.mlg.pong.model.game.elements.Player;
import com.mlg.pong.model.game.elements.Walls;
import com.mlg.pong.model.game.elements.Ball;

import java.util.ArrayList;
import java.util.List;

public class ClassicGameBuilder {

    int height = 30,width=70;

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

    protected List<Player> createPlayers(int i){
        List<Player> players = new ArrayList<>();
        if(i==1){
            for (int r = (height/2)-5; r<(height/2)+1;r++) {
                players.add(new Player(0, r));
            }
        }
        else if(i==2){
            for (int r = (height/2)-5; r<(height/2)+1;r++) {
                players.add(new Player(width-1, r));
            }
        }
        return players;
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
            cgame.setPlayer1(createPlayers(1));
            cgame.setPlayer2(createPlayers(2));
            cgame.setWalls(createWalls());
            cgame.setBall(createBall());
            cgame.setPoint1(0);
            cgame.setPoints2(0);

            return cgame;
    }
}

package com.mlg.pong.model.game.arena;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.elements.Ball;
import com.mlg.pong.model.game.elements.Player;
import com.mlg.pong.model.game.elements.Walls;

import java.util.List;

public class ClassicGame {
    private List<Walls> walls;
    private List<Player> player1,player2;
    private Ball ball;
    private int width,height;

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public List<Player> getPlayer2() {
        return player2;
    }

    public void setPlayer2(List<Player> player2) {
        this.player2 = player2;
    }

    public List<Walls> getWalls() {
        return walls;
    }

    public void setWalls(List<Walls> walls) {
        this.walls = walls;
    }
    public List<Player> getPlayer1() {
        return player1;
    }

    public void setPlayer1(List<Player> player1) {
        this.player1 = player1;
    }

    public boolean isEmpty(Position position) {
        for (Walls wall : walls)
            if (wall.getPosition().equals(position))return false;
        return true;
    }

    public ClassicGame(int width,int height)
    {
        this.width=width;
        this.height=height;
    }

 
}

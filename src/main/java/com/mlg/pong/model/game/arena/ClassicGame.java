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

    private int point1, points2;

    public int getPoints2() {
        return points2;
    }

    public void setPoints2(int points2) {
        this.points2 = points2;
    }

    public int getPoint1() {
        return point1;
    }

    public void setPoint1(int point1) {
        this.point1 = point1;
    }

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
        for(Player p: player1){
            if(p.getPosition().equals(position))return false;
        }
        for(Player p: player2){
            if(p.getPosition().equals(position))return false;
        }
        return true;
    }

    public boolean isPlayer(Position position){
        for(Player p: player1){
            if(p.getPosition().equals(position))return true;
        }
        for(Player p: player2){
            if(p.getPosition().equals(position))return true;
        }
        return false;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isWall(Position position){
        for (Walls wall : walls)
            if (wall.getPosition().equals(position))return true;
        return false;
    }

    public ClassicGame(int width,int height)
    {
        this.width=width;
        this.height=height;
    }


    public void setBall(int i, int i1) {
        ball = new Ball(i,i1);
    }
}

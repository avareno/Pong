package com.mlg.pong.model.game.arena;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.elements.*;

import java.util.List;

public abstract class Game {
    private List<Walls> walls;
    private Player player1;
    private Ball ball;
    private int width,height;
    private int points1, points2;
    private int count;
    private int difficulty;

    public void setPoints2(int points2) {
        this.points2 = points2;
    }

    public void setPoint1(int points1) {
        this.points1 = points1;
    }

    public int getPoints1() {
        return points1;
    }

    public int getPoints2() {
        return points2;
    }

    public void addPoints1() {points1++;}

    public void addPoints2() {points2++;}

    public void addCount() {count++;}

    public void resetCount() {count = 0;}

    public int getCount() {return count;}

    public double ballSpeed() {
        if (count > 16) {
            return 4;
        } else if (count > 8) {
            return 2;
        } else if (count > 4) {
            return 1.5;
        } else if (count > 2) {
            return 1.25;
        } else {return 1;}
    }

    public double comSpeed() {
        if (count > 16) {
            return 1.75;
        } else if (count > 8) {
            return 1.5;
        } else if (count > 4) {
            return 1.25;
        } else if (count > 2) {
            return 1.1;
        } else {return 1;}
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public List<Walls> getWalls() {
        return walls;
    }

    public void setWalls(List<Walls> walls) {
        this.walls = walls;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public boolean isEmpty(Position position){
        for (Walls wall : walls) {
            if (wall.getPosition().equals(position)) return false;
        }
        for(Position p: getPlayer1().getPlayersPositions()){
            if(p.equals(position) || ball.getPosition().equals(position))return false;
        }
        return true;
    }



    public boolean isPlayer(Position position){
        for(Position p : getPlayer1().getPlayersPositions())
            if(p.equals(position))return true;

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

    public boolean isWall(Position position){
        for (Walls wall : walls)
            if (wall.getPosition().equals(position))return true;
        return false;
    }

    public Game(int width,int height)
    {
        this.width=width;
        this.height=height;
        this.count=0;
    }

    public void setBall(int i, int i1) {
        ball = new Ball(i,i1);
    }
}

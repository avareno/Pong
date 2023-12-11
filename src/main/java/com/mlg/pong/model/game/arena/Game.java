package com.mlg.pong.model.game.arena;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.elements.*;

import java.util.List;

public abstract class Game {
    private List<Walls> walls;
    private Player player1;
    private Player player2;
    private Computer computer;
    private Ball ball;
    private PowerUP powerup;
    private int width,height;
    private int points1, points2;

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

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setPowerUP(PowerUP powerup) {this.powerup = powerup;}

    public PowerUP getPowerup() {return powerup;}

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

    public boolean isEmpty(Position position, int i) {
        for (Walls wall : walls) {
            if (wall.getPosition().equals(position)) return false;
        }
        for(Position p: getPlayer1().getPlayersPositions()){
            if(p.equals(position) || ball.getPosition().equals(position))return false;
        }

//        if(i==0) {
//            if (player2 != null) {
//                for (Position p : getPlayer2().getPlayersPositions()) {
//                    if (p.equals(position)) return false;
//                }
//            }
//            } else {
//                for (Position p : getComputer().getPlayersPositions()) {
//                    if (p.equals(position)) return false;
//                }
//            }
//        }
        return true;
    }



    public boolean isPlayer(Position position){
        for(Position p : getPlayer1().getPlayersPositions())
            if(p.equals(position))return true;
//        if (player2 != null) {
//            for (Position p : getPlayer2().getPlayersPositions()) {
//                if (p.equals(position)) return true;
//            }
//        }
        return false;
    }

    public boolean isComputer(Position position){
//        if (computer != null) {
//            for (Position p : getComputer().getPlayersPositions()) {
//                if (p.equals(position)) return true;
//            }
//        }
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

    public Game(int width,int height)
    {
        this.width=width;
        this.height=height;
    }

    public void setBall(int i, int i1) {
        ball = new Ball(i,i1);
    }
}
package com.mlg.pong.model.game.arena;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.elements.*;

import java.util.List;

public class ClassicGame {
    private List<Walls> walls;
    private Player player1;
    private Computer computer;
    private Ball ball;
    private PowerUP powerup;
    private int width,height;

    private int point1, points2;

    public int getPoints2() {
        return points2;
    }

    public void setPoints2(int points2) {
        this.points2 = points2;
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

    public void setPowerUP(PowerUP powerup) {this.powerup = powerup;}

    public PowerUP getPowerup() {return powerup;}

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
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

    public boolean isEmpty(Position position,int i,String type) {

        for (Walls wall : walls) {
            if(type.equals("player")) {
                Player player = getPlayer1();
                if (wall.getPosition().equals(new Position(position.getX(), position.getY() -1)) || wall.getPosition().equals(new Position(position.getX(), position.getY() + player.getSize() - 2))) return false;
            }else if(type.equals("computer")) {
                Player computer = getComputer();
                if (wall.getPosition().equals(new Position(position.getX(), position.getY() -1)) || wall.getPosition().equals(new Position(position.getX(), position.getY() + computer.getSize() - 2))) return false;
            }else{
                if (wall.getPosition().equals(position)) return false;
            }

        }

        if(type.equals("ball")) {
            Player player = getPlayer1();
            for (int c = player.getPosition().getY(); c <= player.getPosition().getY() + player.getSize(); c++) {
                if (position.equals(new Position(player.getPosition().getX(), c))) {
                    return false;
                }
            }
        }


        if(type.equals("ball")) {
            Computer computer = getComputer();
            for (int c = computer.getPosition().getY(); c <= computer.getPosition().getY() + computer.getSize(); c++) {
                if (position.equals(new Position(computer.getPosition().getX(), c))) return false;
            }
        }
        return true;
    }



    public boolean isPlayer(Position position){
        Player player = player1;
        for (int c = player.getPosition().getY(); c < player.getPosition().getY() + player.getSize(); c++) {
            if (position.equals(new Position(player.getPosition().getX(), c))) {
                return true;
            }
        }


        Computer p= computer;
        for (int c = p.getPosition().getY(); c < p.getPosition().getY() + p.getSize(); c++) {
            if (position.equals(new Position(p.getPosition().getX(), c))) {
                return true;
            }
        }
        return false;
    }

    public boolean isPowerUP(Position position) {
        return position.equals(powerup.getPosition());
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
        ball = new Ball(i,i1,0,0);
    }
}

package com.mlg.pong.model.game.arena;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.elements.*;

import java.util.List;

public class ClassicGame {
    private List<Walls> walls;
    private Player player1;
    private Player player2;
    private Computer computer;
    private Ball ball;
    private PowerUP powerup;
    private int count;
    private int difficulty;
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
    public Player getPlayer2() {
        return player2;
    }
    public void setPlayer2(Player player2) {
        this.player2 = player2;
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

        if(i==0) {
            if (player2 != null) {
                for (Position p : getPlayer2().getPlayersPositions()) { // Corrigido! :D
                    if (p.equals(position)) return false;
                }
            } else {
                for (Position p : getComputer().getPlayersPositions()) {
                    if (p.equals(position)) return false;
                }
            }
        }
        return true;
    }



    public boolean isPlayer(Position position){
        for(Position p : getPlayer1().getPlayersPositions())
            if(p.equals(position))return true;
        if (player2 != null) {
            for (Position p : getPlayer2().getPlayersPositions()) {
                if (p.equals(position)) return true;
            }
        }
        return false;
    }

    public boolean isComputer(Position position){
        if (computer != null) {
            for (Position p : getComputer().getPlayersPositions()) {
                if (p.equals(position)) return true;
            }
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
        this.count = 0;
    }

    public void setBall(int i, int i1) {
        ball = new Ball(i,i1);
    }
}

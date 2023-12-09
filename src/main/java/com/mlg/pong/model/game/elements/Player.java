package com.mlg.pong.model.game.elements;


import com.mlg.pong.model.Position;

import java.util.List;

public class Player extends Element {
    private int size;
    private int speed;
    public Player(int x , int y)
    {
        super(x,y);
        this.size = 4;
        this.speed = 1;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public List<Position> getPlayersPositions(){

        List<Position> positions = new java.util.ArrayList<>(); // create new ArrayList
        positions.add(getPosition());
        for(int i = 1; i < this.getSize(); i++) {
            positions.add(new Position(this.getPosition().getX(), this.getPosition().getY() + i));
        }
        for(int i = 1; i < this.getSize(); i++) {
            positions.add(new Position(this.getPosition().getX(), this.getPosition().getY() -i));
        }
        positions.sort(Position::compareTo);
        return positions;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

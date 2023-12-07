package com.mlg.pong.model.game.elements;

import com.mlg.pong.model.Position;

public class Element {
    private Position position;
    private int size;
    private int speed;
    public Element() {
        this.position = new Position();
    }
    public Element(int x , int y,int size,int speed) {

        this.position = new Position(x,y);
        this.size = size;
        this.speed = speed;

    }
    public Position getPosition() {
        return position;
    }
    public int getSize() {
        return size;
    }
    public int getSpeed() {
        return speed;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setSize(int size) {
        this.size = size;
    }

}
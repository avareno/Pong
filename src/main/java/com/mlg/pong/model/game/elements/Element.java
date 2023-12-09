package com.mlg.pong.model.game.elements;

import com.mlg.pong.model.Position;

public class Element {
    private Position position;
    public Element(int x , int y) {

        this.position = new Position(x,y);

    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

}
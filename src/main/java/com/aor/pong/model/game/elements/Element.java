package com.aor.pong.model.game.elements;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.aor.pong.model.Position;

public class Element {
    private Position position;
    public Element() {
        this.position = new Position();
    }
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
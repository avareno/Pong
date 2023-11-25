package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.aor.pong.model.Position;

public abstract class Element {
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
    public void draw(TextGraphics graphics) {
        graphics.enableModifiers(SGR.BOLD);
    }
}
package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Position;

import java.util.Objects;

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
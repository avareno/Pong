package com.aor.pong;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

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

    public static class Application {
        public static void main(String[] args) throws IOException {
            Menu f = new Menu();
            f.run();

        }
    }
}
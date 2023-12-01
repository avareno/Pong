package com.mlg.pong.model.game.elements;

import com.mlg.pong.model.Position;

import java.util.Random;

public class Vector {
    private Position p;
    public Vector() {
        Random rand = new Random();
        int x = rand.nextBoolean() ? 1 : -1;
        int y = rand.nextBoolean() ? 1 : -1;
        p = new Position(x, y);
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    public Vector(Position p){
        this.p=p;
    }


}

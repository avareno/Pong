package com.mlg.pong.model.game.elements;

import com.mlg.pong.model.Position;

public class Ball extends Element{
    private Vector vector;
    public Ball(int x , int y)
    {
        super(x,y);
        this.vector=new Vector();
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }
}

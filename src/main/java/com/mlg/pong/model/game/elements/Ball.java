package com.mlg.pong.model.game.elements;

import com.mlg.pong.model.Position;

public class Ball extends Element{
    private Vector vector;
    public Ball(int x , int y)
    {
        super(x,y);
        this.vector=new Vector();
    }

    public Ball(int x , int y, Vector v)
    {
        super(x,y);
        this.vector=v;
    }


    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public Vector invertVector(){
        setVector(new Vector(new Position(vector.getP().getX(),-vector.getP().getY())));

        return this.vector;
    }
}

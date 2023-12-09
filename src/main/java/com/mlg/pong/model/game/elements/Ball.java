package com.mlg.pong.model.game.elements;

import com.mlg.pong.model.Position;

public class Ball extends Element{
    private Vector vector;
    private int speed;
    public Ball(int x , int y)
    {
        super(x,y);
        this.speed=1;
        this.vector=new Vector();
    }

    public Ball(int x , int y, Vector v, int speed)
    {
        super(x,y);
        this.speed=speed;
        this.vector=v;
    }

    public Ball(int x, int y, Vector vector) {
        super(x,y);
        this.vector = vector;
    }


    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public Vector invertVector(int i){
        if(i == 0) {
            setVector(new Vector(new Position(vector.getP().getX(), -vector.getP().getY())));
        }else if(i == 1){
            setVector(new Vector(new Position(-vector.getP().getX(), vector.getP().getY())));
        }
        return this.vector;
    }
}

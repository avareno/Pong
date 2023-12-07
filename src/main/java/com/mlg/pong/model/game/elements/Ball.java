package com.mlg.pong.model.game.elements;

import com.mlg.pong.model.Position;

public class Ball extends Element{
    private Vector vector;
    public Ball(int x , int y,int size, int speed)
    {
        super(x,y,size,speed);
        this.vector=new Vector();
    }

    public Ball(int x , int y, Vector v,int size, int speed)
    {
        super(x,y,size,speed);
        this.vector=v;
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

package com.mlg.pong.model.game.elements;

public class PowerUP extends Element{
    private boolean consumed;
    public PowerUP(int x, int y, int size, int speed) {super(x,y,size,speed); consumed = false;}
    public void Consume() {consumed = true;}
    public boolean isConsumed() {return consumed;}
}

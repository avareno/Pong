package org.example;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends Element{
    Player(int x, int y){
        setPosition(x,y);
    }
    private void setPosition(int x, int y) {
        Position position = new Position(x,y);
        setPosition(position);
    }
    public void moveup(){
        setPosition(getPosition().getX(), getPosition().getY()-1);
    }
    public void movedown(){
        setPosition(getPosition().getX(), getPosition().getY()+1);
    }

    @Override
    public void draw(TextGraphics graphics) {
        super.draw(graphics);
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()),"█");
    }
}

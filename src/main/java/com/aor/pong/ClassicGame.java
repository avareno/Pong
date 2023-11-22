package com.aor.pong;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClassicGame implements Game{
    private Screen screen;
    private List<Walls> walls;
    private List<Player> player1,player2;
    private int width=100,height=50;

    public List<Player> getPlayer2() {
        return player2;
    }

    public void setPlayer2(List<Player> player2) {
        this.player2 = player2;
    }

    public List<Walls> getWalls() {
        return walls;
    }

    public void setWalls(List<Walls> walls) {
        this.walls = walls;
    }
    public List<Player> getPlayer1() {
        return player1;
    }

    public void setPlayer1(List<Player> player1) {
        this.player1 = player1;
    }

    //Model
    public List<Walls> createWalls(){
        List<Walls> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Walls(c, 0));
            walls.add(new Walls(c, height - 1));
        }
        return walls;
    }
    public List<Player> createPlayers(int i){
        List<Player> players = new ArrayList<>();
        if(i==1){
            for (int r = (height/2)-5; r<(height/2)+1;r++) {
                players.add(new Player(0, r));
            }
        }
        else if(i==2){
            for (int r = (height/2)-5; r<(height/2)+1;r++) {
                players.add(new Player(width-1, r));
            }
        }
        return players;
    }

    //viewer
    private void draw() throws IOException {
        screen.clear();
        TextGraphics textGraphics = screen.newTextGraphics();
        for(Walls at: walls){
            at.draw(textGraphics);
        }
        for(Player at: player1){
            at.draw(textGraphics);
        }
        for(Player at: player2){
            at.draw(textGraphics);
        }
        screen.refresh();
    }

    //controler
    public void processKey(KeyStroke key){
        switch(key.getKeyType()){
            case ArrowUp:
                for(Player at: getPlayer1()){
                    if(at.getPosition().getY()==height - 1)break;
                    at.moveup();
                }
                break;
            case ArrowDown:
                for(Player at: getPlayer1()){
                    if(at.getPosition().getY()==1)break;
                    at.movedown();
                }
                break;
        }
    }
    public void run() throws IOException {
        draw();
        KeyStroke key = screen.readInput();
        while((key.getKeyType()!= KeyType.EOF)) {
            processKey(key);
            draw();
            key = screen.readInput();

        }
    }
    ClassicGame(Screen screen)
    {
        this.screen=screen;
        this.walls = createWalls();
        this.player1 =createPlayers(1);
        this.player2=createPlayers(2);
    }

    public static class DifferentGame implements Game {
        public void draw(){};
        public void run(){};
        public DifferentGame(Screen screen){}

    }
}

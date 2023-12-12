package com.mlg.pong.model.game.arena.classic;
import com.mlg.pong.model.game.arena.GameBuilder;
import com.mlg.pong.model.game.elements.*;

public class ClassicGame1PBuilder extends GameBuilder {
    private int difficulty;
    public ClassicGame1PBuilder(int difficulty) {
        super();
        this.difficulty = difficulty;
    }
    public Player createComputer(){
        return new Player(getWidth()-2, (getHeight()/2));
    }
    public ClassicGame createGame() {
        ClassicGame cgame = new ClassicGame(getWidth(), getHeight());
        cgame.setPlayer1(super.createPlayer());
        cgame.setPlayer2(createComputer());
        cgame.setWalls(createWalls());
        cgame.setBall(createBall());
        cgame.setPoint1(0);
        cgame.setPoints2(0);
        cgame.setDifficulty(difficulty);
        return cgame;
    }
}

package com.mlg.pong.model.game.arena.classic;
import com.mlg.pong.model.game.arena.GameBuilder;
import com.mlg.pong.model.game.elements.Player;

public class ClassicGame2PBuilder extends GameBuilder {
    public ClassicGame2PBuilder() {
        super();
    }
    @Override
    public Player createPlayer() {
        return new Player(getWidth()-2,(getHeight() / 2));
    }


    public ClassicGame createGame() {
        ClassicGame cgame = new ClassicGame(getWidth(), getHeight());
        cgame.setPlayer1(super.createPlayer());
        cgame.setPlayer2(createPlayer());
        cgame.setWalls(createWalls());
        cgame.setBall(createBall());
        cgame.setPoint1(0);
        cgame.setPoints2(0);
        return cgame;
    }
}

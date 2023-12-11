package com.mlg.pong.model.game.arena.classic;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.Game;
import com.mlg.pong.model.game.elements.*;

import java.util.List;

public class ClassicGame extends Game {
    private Player player2;


    public Player getPlayer2() {
        return player2;
    }
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
    @Override
    public boolean isPlayer(Position position) {
        if(super.isPlayer(position))return true;
        else{
            for (Position p : getPlayer2().getPlayersPositions()) {
                if (p.equals(position)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty(Position position) {
        if(!super.isEmpty(position))return false;
        else{
            for (Position p : getPlayer2().getPlayersPositions()) {
                if (p.equals(position)) return false;
            }
        }
        return true;
    }

    public ClassicGame(int width,int height)
    {
        super(width,height);
    }

}

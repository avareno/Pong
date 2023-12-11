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


//    public boolean isEmpty(Position position, int i) {
//        for (Walls wall : walls) {
//            if (wall.getPosition().equals(position)) return false;
//        }
//        for(Position p: getPlayer1().getPlayersPositions()){
//            if(p.equals(position) || ball.getPosition().equals(position))return false;
//        }
//
//        if(i==0) {
//            if (player2 != null) {
//                for (Position p : getPlayer2().getPlayersPositions()) { // Corrigido! :D
//                    if (p.equals(position)) return false;
//                }
//            } else {
//                for (Position p : getComputer().getPlayersPositions()) {
//                    if (p.equals(position)) return false;
//                }
//            }
//        }
//        return true;
//    }


//
//    public boolean isPlayer(Position position){
//        for(Position p : getPlayer1().getPlayersPositions())
//            if(p.equals(position))return true;
//        if (player2 != null) {
//            for (Position p : getPlayer2().getPlayersPositions()) {
//                if (p.equals(position)) return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean isComputer(Position position){
//        if (computer != null) {
//            for (Position p : getComputer().getPlayersPositions()) {
//                if (p.equals(position)) return true;
//            }
//        }
//        return false;
//    }


    public ClassicGame(int width,int height)
    {
        super(width,height);

    }

}

package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.elements.Ball;
import com.mlg.pong.model.game.elements.Computer;
import com.mlg.pong.model.game.elements.Player;

import java.io.IOException;

import static java.lang.Math.abs;

public class ComputerController extends Controller {
    private ClassicGame model = (ClassicGame) getModel();
    private long lastMovement;
    private int count = 0;

    public ComputerController(ClassicGame cgame) {
        super(cgame);
        this.lastMovement=0;
    }

    public int calculatePosition(Ball ball){
        int res=ball.getPosition().getX(),res1=ball.getPosition().getY();
        if(ball.getVector().getP().getX()==1) {
            while (res != model.getWidth() - 1) {
                res += ball.getVector().getP().getX();
                res1 += ball.getVector().getP().getY();
            }
            if (res1 < model.getComputer().getPosition().getY() || res1 <= 0) {
                return -1;
            } else if(res1 > model.getComputer().getPosition().getY()){
                return 1;
            }
        }
        return 0;
    }

    public void moveDownComputer(){
        int positionAdjustment = calculatePosition(model.getBall());
        if (model.isEmpty(new Position(model.getComputer().getPosition().getX(),model.getComputer().getPlayersPositions().get(model.getComputer().getPlayersPositions().size()-1).getY() + positionAdjustment), 1)) {

            Computer computer = model.getComputer();
                computer.setPosition(new Position(computer.getPosition().getX(), computer.getPosition().getY() + positionAdjustment));

        }
    }
    public void moveUpComputer(){
        int positionAdjustment = calculatePosition(model.getBall());
        if (model.isEmpty(new Position(model.getComputer().getPosition().getX(),model.getComputer().getPlayersPositions().get(0).getY() + positionAdjustment), 1)) {

            Computer computer = model.getComputer();
            computer.setPosition(new Position(computer.getPosition().getX(), computer.getPosition().getY() + positionAdjustment));

        }
    }
    public void moveComputer() {
        if(calculatePosition(model.getBall())==-1)moveUpComputer();
        else moveDownComputer();
    }
    @Override
    public void step(Application app, GUI.ACTION action, long time){
        if(count<2) {
            if (time - lastMovement > 100) {
                moveComputer();
                lastMovement = time;
            }
        }else{
            if (time - lastMovement > 0.0005) {
                moveComputer();
                lastMovement = time;
            }
        }
        if(model.getBall().getPosition().getX()==(model.getComputer().getPosition().getX()-1)){
            count++;
        }
    }
}
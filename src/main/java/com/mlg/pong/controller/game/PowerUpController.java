package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.elements.PowerUP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PowerUpController extends Controller {
    private ClassicGame model = (ClassicGame) getModel();
    private int defaultsize;
    private boolean flag;
    private long last;
    private List<Integer> playerX;


    public PowerUpController(ClassicGame cgame) {
        super(cgame);
        this.flag = false;
        this.last = 0;
        this.defaultsize = model.getPlayer1().getSize();
        playerX = new ArrayList<>();
        playerX.add(model.getPlayer1().getPosition().getX());
        if (model.getPlayer2() != null) {
            playerX.add(model.getPlayer2().getPosition().getX());
        } else {
            playerX.add(model.getComputer().getPosition().getX());
        }
    }

    public int generateRandX() {
        Random random = new Random();
        return playerX.get(random.nextInt(0, 2));
    }

    public int generateRandY() {
        Random random = new Random();
        while (true) {
            Position pos = new Position(0,random.nextInt(3,model.getHeight()-3));
            if (!model.isPlayer(pos) && !model.isComputer(pos)) {return pos.getY();}
        }
    }

    public void checkPlayerPos() {
        if(model.isPlayer(model.getPowerup().getPosition()) || model.isComputer(model.getPowerup().getPosition())) {
            model.getPowerup().Consume();
        }
    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        if (!flag) {
            if (time - last > 25000) {
                model.setPowerUP(new PowerUP(generateRandX(), generateRandY()));
                flag = true;
            }
            if (time - last > 12500) {
                model.getPlayer1().setSize(defaultsize);
                if (model.getPlayer2() != null) {
                    model.getPlayer2().setSize(defaultsize);
                } else {model.getComputer().setSize(defaultsize);}
            }
        } else if(model.getPowerup().isConsumed()) {
            last = time;
            flag = false;
            if (model.getPowerup().getPosition().getX() == playerX.get(0)) {
                model.getPlayer1().setSize(defaultsize + 2);
            }else {
                if (model.getPlayer2() != null) {
                    model.getPlayer2().setSize(defaultsize + 2);
                } else {model.getComputer().setSize(defaultsize + 2);}
            }
        }
        checkPlayerPos();
    }
}

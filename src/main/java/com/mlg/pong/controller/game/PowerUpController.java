package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.game.elements.PowerUP;

import java.io.IOException;
import java.util.Random;

public class PowerUpController extends Controller {
    private ClassicGame model = (ClassicGame) getModel();
    private int defaultsize;
    private boolean flag;
    private long last;

    public PowerUpController(ClassicGame cgame) {
        super(cgame);
        this.flag = false;
        this.last = 0;
        this.defaultsize = model.getPlayer1().getSize();
    }

    public int generateRandY() {
        Random random = new Random();
        while (true) {
            Position pos = new Position(0,random.nextInt(3,model.getHeight()-3));
            if (!model.isPlayer(pos)) {return pos.getY();}
        }
    }

    public void checkPlayerPos() {
        if(model.isPlayer(model.getPowerup().getPosition())) {
            model.getPowerup().Consume();
        }
    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        if (!flag) {
            if (time - last > 25000) {
                model.setPowerUP(new PowerUP(0, generateRandY()));
                flag = true;
            }
            if (time - last > 12500) {
                model.getPlayer1().setSize(defaultsize);
            }
        } else if(model.getPowerup().isConsumed()) {
            last = time;
            flag = false;
            model.getPlayer1().setSize(defaultsize+2);
        }
        checkPlayerPos();
    }
}

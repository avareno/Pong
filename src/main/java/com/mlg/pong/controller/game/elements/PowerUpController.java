package com.mlg.pong.controller.game.elements;
import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.model.game.elements.PowerUP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PowerUpController extends Controller {
    private SpecialGame model = (SpecialGame) getModel();
    private int defaultsize;
    private boolean flag;
    private long last;
    private List<Integer> playerX;


    public PowerUpController(SpecialGame sgame) {
        super(sgame);
        this.flag = false;
        this.last = 0;
        this.defaultsize = model.getPlayer1().getSize();
        playerX = new ArrayList<>();
        playerX.add(model.getPlayer1().getPosition().getX());
        playerX.add(model.getPlayer2().getPosition().getX());
    }

    public int generateRandX() {
        Random random = new Random();
        return playerX.get(random.nextInt(0, 2));
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
                model.setPowerup(new PowerUP(generateRandX(), generateRandY()));
                flag = true;
            }
            if (time - last > 12500) {
                model.getPlayer1().setSize(defaultsize);
                model.getPlayer2().setSize(defaultsize);
            }
        } else if(model.getPowerup().isConsumed()) {
            last = time;
            flag = false;
            if (model.getPowerup().getPosition().getX() == playerX.get(0)) {
                model.getPlayer1().setSize(defaultsize + 2);
            }else {
                model.getPlayer2().setSize(defaultsize + 2);
            }
        }
        checkPlayerPos();
    }
}

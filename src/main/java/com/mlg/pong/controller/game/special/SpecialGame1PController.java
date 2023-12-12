package com.mlg.pong.controller.game.special;

import com.mlg.pong.Application;
import com.mlg.pong.controller.game.elements.PowerUpController;
import com.mlg.pong.controller.game.classic.ClassicGame1PController;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.states.MenuState;

import java.io.IOException;

public class SpecialGame1PController extends ClassicGame1PController {
    private final PowerUpController powerUpController;

    public SpecialGame1PController(SpecialGame sgame) {
        super(sgame);
        this.powerUpController = new PowerUpController(sgame);
    }

    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel() == null)
            app.setState(new MenuState(new Menu()));
        else {
            powerUpController.step(app,action,time);
        }
    }
}

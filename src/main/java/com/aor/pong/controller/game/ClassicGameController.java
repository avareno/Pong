package com.aor.pong.controller.game;

import com.aor.pong.Application;
import com.aor.pong.controller.Controller;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.arena.ClassicGame;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.states.MenuState;

import java.io.IOException;

public class ClassicGameController extends Controller {
    private final PlayerController playerController;

    public ClassicGameController(ClassicGame cgame) {
        super(cgame);

        this.playerController = new PlayerController(cgame);
    }

    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel() == null)
            app.setState(new MenuState(new Menu()));
        else {
            playerController.step(app, action, time);

        }
    }
}

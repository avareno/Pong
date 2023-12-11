package com.mlg.pong.controller.game.classic;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.game.BallController;
import com.mlg.pong.controller.game.ComputerController;
import com.mlg.pong.controller.game.Player1Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.states.MenuState;

import java.io.IOException;

public class ClassicGame1PController extends Controller {
    private final Player1Controller playerController;
    private final BallController ballController;
    private final ComputerController computerController;

    public ClassicGame1PController(ClassicGame cgame) {
        super(cgame);

        this.playerController = new Player1Controller(cgame);
        this.ballController = new BallController(cgame);
        this.computerController= new ComputerController(cgame);
    }

    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel() == null)
            app.setState(new MenuState(new Menu()));
        else {
            playerController.step(app, action, time);
            ballController.step(app,action,time);
            computerController.step(app,action,time);
        }
    }
}

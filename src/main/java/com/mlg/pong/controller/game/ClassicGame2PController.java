package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.states.MenuState;

import java.io.IOException;

public class ClassicGame2PController extends Controller {
    private final PlayerController playerController;
    private final BallController ballController;
    private final Player2Controller player2Controller;
    private final PowerUpController powerUpController;

    public ClassicGame2PController(ClassicGame cgame) {
        super(cgame);

        this.playerController = new PlayerController(cgame);
        this.player2Controller= new Player2Controller(cgame);
        this.ballController = new BallController(cgame);
        this.powerUpController = new PowerUpController(cgame);
    }

    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel() == null)
            app.setState(new MenuState(new Menu()));
        else {
            playerController.step(app, action, time);
            ballController.step(app,action,time);
            player2Controller.step(app,action,time);
            powerUpController.step(app,action,time);
        }
    }
}

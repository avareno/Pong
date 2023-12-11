package com.mlg.pong.controller.menu;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.menu.ClassicGameMenu;
import com.mlg.pong.model.menu.GameOver;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.model.menu.OtherMenu;
import com.mlg.pong.states.ClassicGameMenuState;
import com.mlg.pong.states.MenuState;
import com.mlg.pong.states.OtherMenuState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver model) {
        super(model);
    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedMenu()) app.setState(new MenuState(new Menu()));
                if (getModel().isSelectedExit()) app.setState(null);
        }
    }
}

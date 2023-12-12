package com.mlg.pong.controller.menu;
import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.classic.ClassicGame2PBuilder;
import com.mlg.pong.model.menu.ClassicGameMenu;
import com.mlg.pong.model.menu.DifficultySelector;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.states.classic.ClassicGame2PState;
import com.mlg.pong.states.classic.DifficultySelectorClassicState;
import com.mlg.pong.states.MenuState;

import java.io.IOException;

public class ClassicGameMenuController extends Controller<ClassicGameMenu> {
    public ClassicGameMenuController(ClassicGameMenu menu) {
        super(menu);
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
                if (getModel().isSelected(0)) app.setState(new ClassicGame2PState(new ClassicGame2PBuilder().createGame()));
                if (getModel().isSelected(1)) app.setState(new DifficultySelectorClassicState(new DifficultySelector()));
                if (getModel().isSelected(2)) app.setState(new MenuState(new Menu()));
        }
    }
}

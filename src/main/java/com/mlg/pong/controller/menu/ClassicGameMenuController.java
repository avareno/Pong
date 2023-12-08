package com.mlg.pong.controller.menu;
import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.model.game.arena.ClassicGameBuilder;
import com.mlg.pong.model.menu.ClassicGameMenu;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.model.menu.OtherMenu;
import com.mlg.pong.states.ClassicGameState;
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
                if (getModel().isSelected(0)) app.setState(new ClassicGameState(new ClassicGameBuilder().createClassicGame()));
                if (getModel().isSelected(1)) app.setState(new ClassicGameState(new ClassicGameBuilder().createClassicGame()));

        }
    }
}

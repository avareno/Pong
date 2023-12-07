package com.mlg.pong.controller.menu;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
//import com.aor.hero.model.game.arena.LoaderArenaBuilder;
import com.mlg.pong.model.game.arena.ClassicGameBuilder;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.states.ClassicGameState;
//import com.aor.hero.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
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
                if (getModel().isSelectedExit()) app.setState(null);
                if (getModel().isSelectedClassicGame()) app.setState(new ClassicGameState(new ClassicGameBuilder(app).createClassicGame()));
        }
    }
}

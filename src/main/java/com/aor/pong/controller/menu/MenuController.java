package com.aor.pong.controller.menu;

import com.aor.pong.Application;
import com.aor.pong.controller.Controller;
import com.aor.pong.gui.GUI;
//import com.aor.hero.model.game.arena.LoaderArenaBuilder;
import com.aor.pong.model.game.arena.ClassicGame;
import com.aor.pong.model.game.arena.ClassicGameBuilder;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.states.ClassicGameState;
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
                if (getModel().isSelectedClassicGame()) app.setState(new ClassicGameState(new ClassicGameBuilder().createClassicGame()));
        }
    }
}

package com.mlg.pong.controller.menu;
import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.SpecialGameBuilder;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.model.menu.OtherMenu;
import com.mlg.pong.states.MenuState;
import com.mlg.pong.states.SpecialGameState;

import java.io.IOException;

public class OtherMenuController extends Controller<OtherMenu> {
    public OtherMenuController(OtherMenu menu) {
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
                if(getModel().isSelected(0)) app.setState(new SpecialGameState(new SpecialGameBuilder().createSpecialGame()));
                if (getModel().isSelected(3)) app.setState(new MenuState(new Menu()));
        }
    }
}

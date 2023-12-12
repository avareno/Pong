package com.mlg.pong.controller.menu;
import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.special.SpecialGame2PBuilder;
import com.mlg.pong.model.menu.DifficultySelector;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.model.menu.OtherMenu;
import com.mlg.pong.states.special.DifficultySelectorSpecialState;
import com.mlg.pong.states.MenuState;
import com.mlg.pong.states.special.SpecialGame2PState;

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
                if(getModel().isSelected(0)) app.setState(new DifficultySelectorSpecialState(new DifficultySelector()));
                if(getModel().isSelected(1)) app.setState(new SpecialGame2PState(new SpecialGame2PBuilder().createGame()));
                if (getModel().isSelected(2)) app.setState(new MenuState(new Menu()));
        }
    }
}

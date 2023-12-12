package com.mlg.pong.controller.menu;
import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.classic.ClassicGame1PBuilder;
import com.mlg.pong.model.menu.DifficultySelector;
import com.mlg.pong.states.classic.ClassicGame1PState;

import java.io.IOException;

public class DifficultySelectorClassicController extends Controller<DifficultySelector> {
    public DifficultySelectorClassicController(DifficultySelector menu) {
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
                if(getModel().isSelected(0)) app.setState(new ClassicGame1PState(new ClassicGame1PBuilder(1).createGame()));
                if(getModel().isSelected(1)) app.setState(new ClassicGame1PState(new ClassicGame1PBuilder(2).createGame()));
                if (getModel().isSelected(2)) app.setState(new ClassicGame1PState(new ClassicGame1PBuilder(3).createGame()));
        }
    }
}

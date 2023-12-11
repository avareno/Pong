package com.mlg.pong.controller.menu;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.SpecialGame1PBuilder;
import com.mlg.pong.model.menu.DifficultySelector;
import com.mlg.pong.states.SpecialGame1PState;

import java.io.IOException;

public class DifficultySelectorSpecialController extends Controller<DifficultySelector> {
    public DifficultySelectorSpecialController(DifficultySelector menu) {
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
                if(getModel().isSelected(0)) app.setState(new SpecialGame1PState(new SpecialGame1PBuilder().createSpecialGame(1)));
                if(getModel().isSelected(1)) app.setState(new SpecialGame1PState(new SpecialGame1PBuilder().createSpecialGame(2)));
                if (getModel().isSelected(2)) app.setState(new SpecialGame1PState(new SpecialGame1PBuilder().createSpecialGame(3)));
        }
    }
}

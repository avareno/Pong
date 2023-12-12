package com.mlg.pong.states.special;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.game.special.SpecialGame1PController;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.states.State;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.game.special.SpecialGameViewer;

public class SpecialGame1PState extends State {
    public SpecialGame1PState(SpecialGame sgame) {
        super(sgame);
    }

    @Override
    protected Viewer<SpecialGame> getViewer() {
        return new SpecialGameViewer((SpecialGame) getModel());
    }

    @Override
    protected Controller<SpecialGame> getController() {
        return new SpecialGame1PController((SpecialGame) getModel());
    }
}

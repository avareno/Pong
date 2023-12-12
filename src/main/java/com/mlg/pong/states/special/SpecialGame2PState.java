package com.mlg.pong.states.special;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.game.special.SpecialGame2PController;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.states.State;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.game.special.SpecialGameViewer;

public class SpecialGame2PState extends State {
    public SpecialGame2PState(SpecialGame cgame) {
        super(cgame);
    }

    @Override
    protected Viewer<SpecialGame> getViewer() {
        return new SpecialGameViewer((SpecialGame) getModel());
    }

    @Override//make controller
    protected Controller<SpecialGame> getController() {
        return new SpecialGame2PController((SpecialGame) getModel());
    }
}

package com.mlg.pong.states.special;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.game.special.SpecialGame2PController;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.states.State;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.game.special.SpecialGame1PViewer;

public class SpecialGame2PState extends State {
    public SpecialGame2PState(ClassicGame cgame) {
        super(cgame);
    }

    @Override
    protected Viewer<ClassicGame> getViewer() {
        return new SpecialGame1PViewer((SpecialGame) getModel());
    }

    @Override//make controller
    protected Controller<ClassicGame> getController() {
        return new SpecialGame2PController((SpecialGame) getModel());
    }
}

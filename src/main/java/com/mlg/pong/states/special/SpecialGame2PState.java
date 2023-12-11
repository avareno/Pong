package com.mlg.pong.states.special;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.game.special.SpecialGame2PController;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.states.State;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.game.classic.ClassicGame2PViewer;

public class SpecialGame2PState extends State {
    public SpecialGame2PState(ClassicGame cgame) {
        super(cgame);
    }

    @Override
    protected Viewer<ClassicGame> getViewer() {
        return new ClassicGame2PViewer((ClassicGame) getModel());
    }

    @Override//make controller
    protected Controller<ClassicGame> getController() {
        return new SpecialGame2PController((ClassicGame) getModel());
    }
}

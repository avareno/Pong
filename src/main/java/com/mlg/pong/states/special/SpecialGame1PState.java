package com.mlg.pong.states.special;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.game.special.SpecialGame1PController;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.states.State;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.game.classic.ClassicGame1PViewer;

public class SpecialGame1PState extends State {
    public SpecialGame1PState(ClassicGame cgame) {
        super(cgame);
    }

    @Override
    protected Viewer<ClassicGame> getViewer() {
        return new ClassicGame1PViewer((ClassicGame) getModel());
    }

    @Override
    protected Controller<ClassicGame> getController() {
        return new SpecialGame1PController((ClassicGame) getModel());
    }
}

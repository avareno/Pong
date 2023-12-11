package com.mlg.pong.states.classic;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.game.classic.ClassicGame2PController;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.states.State;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.game.classic.ClassicGame2PViewer;

public class ClassicGame2PState extends State {
    public ClassicGame2PState(ClassicGame cgame) {
        super(cgame);
    }

    @Override
    protected Viewer<ClassicGame> getViewer() {
        return new ClassicGame2PViewer((ClassicGame) getModel());
    }

    @Override//make controller
    protected Controller<ClassicGame> getController() {
        return new ClassicGame2PController((ClassicGame) getModel());
    }
}

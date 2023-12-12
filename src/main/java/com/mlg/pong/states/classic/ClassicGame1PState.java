package com.mlg.pong.states.classic;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.game.classic.ClassicGame1PController;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.states.State;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.game.classic.ClassicGameViewer;

public class ClassicGame1PState extends State {
    public ClassicGame1PState(ClassicGame cgame) {
        super(cgame);
    }

    @Override
    protected Viewer<ClassicGame> getViewer() {
        return new ClassicGameViewer((ClassicGame) getModel());
    }

    @Override//make controller
    protected Controller<ClassicGame> getController() {
        return new ClassicGame1PController((ClassicGame) getModel());
    }
}

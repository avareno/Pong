package com.mlg.pong.states;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.game.ClassicGame1PController;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.game.ClassicGame1PViewer;

public class ClassicGame1PState extends State{
    public ClassicGame1PState(ClassicGame cgame) {
        super(cgame);
    }

    @Override
    protected Viewer<ClassicGame> getViewer() {
        return new ClassicGame1PViewer((ClassicGame) getModel());
    }

    @Override//make controller
    protected Controller<ClassicGame> getController() {
        return new ClassicGame1PController((ClassicGame) getModel());
    }
}

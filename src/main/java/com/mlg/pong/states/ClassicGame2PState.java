package com.mlg.pong.states;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.game.ClassicGame2PController;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.game.ClassicGame2PViewer;
import com.mlg.pong.viewer.game.ClassicGameViewer;

public class ClassicGame2PState extends State{
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

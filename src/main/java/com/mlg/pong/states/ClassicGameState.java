package com.mlg.pong.states;

import com.mlg.pong.controller.Controller;
//import com.aor.pong.controller.game.ClassicGameController;
import com.mlg.pong.controller.game.ClassicGameController;
import com.mlg.pong.model.game.arena.ClassicGame;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.game.ClassicGameViewer;
//import com.aor.pong.viewer.game.GameViewer;

public class ClassicGameState extends State{
    public ClassicGameState(ClassicGame cgame) {
        super(cgame);
    }

    @Override
    protected Viewer<ClassicGame> getViewer() {
        return new ClassicGameViewer((ClassicGame) getModel());
    }

    @Override//make controller
    protected Controller<ClassicGame> getController() {
        return new ClassicGameController((ClassicGame) getModel());
    }
}

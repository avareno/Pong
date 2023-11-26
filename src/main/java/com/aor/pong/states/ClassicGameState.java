package com.aor.pong.states;

import com.aor.pong.controller.Controller;
//import com.aor.pong.controller.game.ClassicGameController;
import com.aor.pong.controller.game.ClassicGameController;
import com.aor.pong.model.game.arena.ClassicGame;
import com.aor.pong.viewer.Viewer;
import com.aor.pong.viewer.game.ClassicGameViewer;
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

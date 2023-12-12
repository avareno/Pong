package com.mlg.pong.states;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.menu.GameOverController;
import com.mlg.pong.model.menu.GameOver;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.menu.GameOverViewer;

public class GameOverState extends State<GameOver> {

    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
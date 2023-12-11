package com.mlg.pong.states.classic;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.menu.DifficultySelectorClassicController;
import com.mlg.pong.controller.menu.OtherMenuController;
import com.mlg.pong.model.menu.DifficultySelector;
import com.mlg.pong.model.menu.OtherMenu;
import com.mlg.pong.states.State;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.menu.DifficultySelectorViewer;
import com.mlg.pong.viewer.menu.OtherMenuViewer;

public class DifficultySelectorClassicState extends State<DifficultySelector> {
    public DifficultySelectorClassicState(DifficultySelector model) {
        super(model);
    }

    @Override
    protected Viewer<DifficultySelector> getViewer() {
        return new DifficultySelectorViewer(getModel());
    }

    @Override
    protected Controller<DifficultySelector> getController() {
        return new DifficultySelectorClassicController(getModel());
    }
}
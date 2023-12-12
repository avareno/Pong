package com.mlg.pong.states.special;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.menu.DifficultySelectorSpecialController;
import com.mlg.pong.model.menu.DifficultySelector;
import com.mlg.pong.states.State;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.menu.DifficultySelectorViewer;

public class DifficultySelectorSpecialState extends State<DifficultySelector> {
    public DifficultySelectorSpecialState(DifficultySelector model) {
        super(model);
    }

    @Override
    protected Viewer<DifficultySelector> getViewer() {
        return new DifficultySelectorViewer(getModel());
    }

    @Override
    protected Controller<DifficultySelector> getController() {
        return new DifficultySelectorSpecialController(getModel());
    }
}
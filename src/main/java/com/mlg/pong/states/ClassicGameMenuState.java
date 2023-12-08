package com.mlg.pong.states;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.menu.ClassicGameMenuController;
import com.mlg.pong.model.menu.ClassicGameMenu;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.menu.ClassicGameMenuViewer;

public class ClassicGameMenuState extends State<ClassicGameMenu> {
    public ClassicGameMenuState(ClassicGameMenu model) {
        super(model);
    }

    @Override
    protected Viewer<ClassicGameMenu> getViewer() { return new ClassicGameMenuViewer(getModel()); }

    @Override
    protected Controller<ClassicGameMenu> getController() {return new ClassicGameMenuController(getModel());}
}
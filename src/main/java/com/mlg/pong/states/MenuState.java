package com.mlg.pong.states;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.menu.MenuController;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}

package com.aor.pong.states;

import com.aor.pong.controller.Controller;
import com.aor.pong.controller.menu.MenuController;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.viewer.Viewer;
import com.aor.pong.viewer.menu.MenuViewer;

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

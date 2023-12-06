package com.mlg.pong.states;

import com.mlg.pong.controller.Controller;
import com.mlg.pong.controller.menu.MenuController;
import com.mlg.pong.controller.menu.OtherMenuController;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.model.menu.OtherMenu;
import com.mlg.pong.viewer.Viewer;
import com.mlg.pong.viewer.menu.MenuViewer;
import com.mlg.pong.viewer.menu.OtherMenuViewer;

public class OtherMenuState extends State<OtherMenu> {
    public OtherMenuState(OtherMenu model) {
        super(model);
    }

    @Override
    protected Viewer<OtherMenu> getViewer() {
        return new OtherMenuViewer(getModel());
    }

    @Override
    protected Controller<OtherMenu> getController() {
        return new OtherMenuController(getModel());
    }
}
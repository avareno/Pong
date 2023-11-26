package com.aor.pong.states;

import com.aor.pong.Application;
import com.aor.pong.controller.Controller;
import com.aor.pong.gui.GUI;
import com.aor.pong.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Application app, GUI gui, long time) throws IOException {




        GUI.ACTION action = gui.getNextAction();
        controller.step(app, action, time);
        viewer.draw(gui);
    }
}

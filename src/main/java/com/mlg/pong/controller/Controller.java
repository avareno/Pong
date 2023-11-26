package com.mlg.pong.controller;

import com.mlg.pong.Application;
import com.mlg.pong.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Application app, GUI.ACTION action, long time) throws IOException;
}

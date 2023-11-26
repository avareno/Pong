package com.mlg.pong.viewer.game;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}

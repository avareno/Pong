package com.aor.pong.viewer.game;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}

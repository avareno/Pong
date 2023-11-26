package com.aor.pong.viewer.menu;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(25, 15), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(25, 17 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#00ffd4" : "#FFFFFF");
    }
}

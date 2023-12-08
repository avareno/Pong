package com.mlg.pong.viewer.menu;


import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.menu.ClassicGameMenu;
import com.mlg.pong.viewer.Viewer;

public class ClassicGameMenuViewer extends Viewer<ClassicGameMenu> {
    public ClassicGameMenuViewer(ClassicGameMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(25, 17 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#00ffd4" : "#FFFFFF");
    }
}

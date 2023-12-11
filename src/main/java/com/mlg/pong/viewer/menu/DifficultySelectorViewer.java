package com.mlg.pong.viewer.menu;


import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.menu.DifficultySelector;
import com.mlg.pong.model.menu.OtherMenu;
import com.mlg.pong.viewer.Viewer;

public class DifficultySelectorViewer extends Viewer<DifficultySelector> {
    public DifficultySelectorViewer(DifficultySelector menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(25, 15), "Select Computer Difficulty", "#FFFFFF");
        gui.drawText(new Position(25, 17),
            getModel().getEntry(0),
            getModel().isSelected(0) ? "#00ffd4" : "#00FC00");
        gui.drawText(new Position(25, 18),
                getModel().getEntry(1),
                getModel().isSelected(1) ? "#00ffd4" : "#FCDD00");
        gui.drawText(new Position(25, 19),
                getModel().getEntry(2),
                getModel().isSelected(2) ? "#00ffd4" : "#FF0000");
    }
}

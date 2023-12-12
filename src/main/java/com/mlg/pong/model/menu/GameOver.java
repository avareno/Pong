package com.mlg.pong.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final String whoWon;

    public GameOver(String name) {
        this.whoWon = name;
        this.entries = Arrays.asList("Exit", "Menu");
    }

    public String getWhoWon() {
        return whoWon;
    }

    private final List<String> entries;
    private int currentEntry = 0;

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }//get current entry

    public boolean isSelected(int i) {
        return currentEntry == i;
    }//check if is selected

    public boolean isSelectedExit() {
        return isSelected(0);
    }//specific entry

    public boolean isSelectedMenu() {
        return isSelected(1);
    }//specific entry

    public int getNumberEntries() {
        return this.entries.size();
    }//get number of entries
}
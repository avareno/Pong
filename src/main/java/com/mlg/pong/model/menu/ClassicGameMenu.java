package com.mlg.pong.model.menu;

import java.util.Arrays;
import java.util.List;

public class ClassicGameMenu {
    private final List<String> entries;
    private int currentEntry = 0;

    public ClassicGameMenu() {
        this.entries = Arrays.asList("Player vs. Player","Player vs. COM");
    }

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
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }


    public int getNumberEntries() {
        return this.entries.size();
    }
}
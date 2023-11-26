package com.mlg.pong.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {

    private final List<String> entries;//list with the options
    private int currentEntry = 0;//current option

    public Menu() {
        this.entries = Arrays.asList("Classic", "Different Modes","Exit");
    }//inicialization

    public void nextEntry() {//fetch next entry
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {//fetch previous entry
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
        return isSelected(2);
    }//specific entry

    public boolean isSelectedOtherGame() {
        return isSelected(1);
    }//specific entry
    public boolean isSelectedClassicGame() {
        return isSelected(0);
    }//specific entry

    public int getNumberEntries() {
        return this.entries.size();
    }//get number of entries

}

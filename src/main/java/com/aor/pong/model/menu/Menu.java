package org.example;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Menu {

    private int count=0;


    private Screen screen;
    private int width=100,height=50;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private void draw() throws IOException {
        screen.clear();
        int cursorX=(width*2)/5;
        int cursorY=(height*2)/5;
        TextGraphics textGraphics = screen.newTextGraphics();

        // Draw three 'X' characters, and change the color based on count % 3
        for (int i = 0; i < 3; i++) {
            if (count % 3 == i) {
                textGraphics.setForegroundColor(TextColor.ANSI.RED);
            } else {
                textGraphics.setForegroundColor(TextColor.ANSI.DEFAULT);
            }
            switch(i){

                case 0:   textGraphics.putString(cursorX, cursorY + i * 2, "Clássico");
                break;
                case 1:
                    textGraphics.putString(cursorX, cursorY + i * 2, "Modos diferentes");
                    break;
                case 2:
                    textGraphics.putString(cursorX, cursorY + i * 2, "End of Game");
                    break;
            }


        }

        screen.refresh();
    }
    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();

            if (key.getKeyType() == KeyType.Enter) {
                break; // exit the loop on Enter key
            } else if (key.getKeyType() == KeyType.ArrowDown) {
                count++;
            } else if (key.getKeyType() == KeyType.ArrowUp) {
                count--;
            }
            if(count<0){
                count=3+count;
            }
        }
        switch(count%3){
            case 0:
                ClassicGame cg = new ClassicGame(screen);
                cg.run();
                break;
            case 1:
                ClassicGame.DifferentGame dg = new ClassicGame.DifferentGame(screen);
                dg.run();
                break;
            case 2:
                screen.close();
                break;
        }


    }
    Menu()
    {
        try {
            TerminalSize terminalSize = new TerminalSize(width, height);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

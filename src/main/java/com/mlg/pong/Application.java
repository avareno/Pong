package com.mlg.pong;

import com.mlg.pong.gui.LanternaGUI;
import com.mlg.pong.model.menu.Menu;
import com.mlg.pong.states.MenuState;
import com.mlg.pong.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private final LanternaGUI gui;
    private State state;
    public Application() throws FontFormatException, IOException, URISyntaxException {

        this.gui = new LanternaGUI(70, 30);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Application().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    public static String extractClassName(String objectRepresentation) {
            // Dividir a string usando "@" como delimitador
            String[] parts = objectRepresentation.split("@");

            // Obter a parte que contém o nome da classe
            String classPart = parts[0];

            // Extrair o nome da classe
            int lastDotIndex = classPart.lastIndexOf(".");
            return classPart.substring(lastDotIndex + 1);
    }
    private void start() throws IOException {
        int FPS = 100;
        int frameTime = 1000 / FPS;


        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }



}

package org.example;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.states.MenuState;
import com.aor.pong.states.State;

import java.io.IOException;

public class Application {

    private State state;
    private GUI gui;
    public Application(){
        this.state=new MenuState(new Menu());
    }

    public void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while(state!=null){
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
    }
    public static void main(String[] args) throws IOException {
        new Application().start();
    }


}

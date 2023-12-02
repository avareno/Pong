package com.mlg.pong.controller.game;

import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.ClassicGame;

import java.io.IOException;

public class ComputerPlayerController extends Controller {

    public ComputerPlayerController(ClassicGame cgame) {
        super(cgame);
    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) throws IOException {

    }
}

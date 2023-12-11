//package com.mlg.pong.viewer;
//
//import com.mlg.pong.gui.GUI;
//import com.mlg.pong.model.Position;
//import com.mlg.pong.model.game.arena.classic.ClassicGame;
//import com.mlg.pong.model.game.arena.ClassicGameBuilder;
//import com.mlg.pong.model.game.elements.Ball;
//import com.mlg.pong.model.game.elements.Player;
//import com.mlg.pong.model.game.elements.Walls;
//import com.mlg.pong.viewer.game.ClassicGameViewer;
//import com.sun.source.tree.ModuleTree;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.mock;
//
//public class GameViewerTest {
//    private GUI gui;
//    private ClassicGameViewer viewer;
//    private ClassicGame game;
//
//    private ClassicGameBuilder builder;
//
//    @BeforeEach
//    void setUp() {
//        gui = Mockito.mock(GUI.class);
//        builder = new ClassicGameBuilder();
//        game = builder.createClassicGame();
//        viewer = new ClassicGameViewer(game);
//    }
//
//    @Test
//    void drawWalls() throws IOException {
//        viewer.draw(gui);
//
//        for (int i = 0; i < builder.getWidth(); i++) {
//            Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(i,0));
//            Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(i,builder.getHeight()-1));
//        }
//
//        Mockito.verify(gui, Mockito.times(140)).drawWall(Mockito.any(Position.class));
//    }
//
//    @Test
//    void drawBall() throws IOException {
//        viewer.draw(gui);
//
//        Mockito.verify(gui, Mockito.times(1)).drawBall(new Position(builder.getWidth()/2,builder.getHeight()/2));
//        Mockito.verify(gui, Mockito.times(1)).drawBall(Mockito.any(Position.class));
//    }
//
//    @Test
//    void drawPlayer() throws IOException {
//        viewer.draw(gui);
//
//        for (int i = 10; i < 16; i++) {
//            Mockito.verify(gui, Mockito.times(1)).drawPlayer(new Position(0,i));
//            Mockito.verify(gui, Mockito.times(1)).drawPlayer(new Position(builder.getWidth()-1,i));
//        }
//        Mockito.verify(gui, Mockito.times(12)).drawPlayer(Mockito.any(Position.class));
//    }
//}

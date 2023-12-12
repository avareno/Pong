package com.mlg.pong.gui;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.elements.Player;

import java.awt.*;
import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawWall(Position position);

    void drawPowerUp(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawPlayer(Player player);

    void drawBall(Position position);

    enum ACTION {UP, DOWN, P2UP, P2DOWN, NONE, QUIT, SELECT}
}

package com.aor.pong.viewer.game;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.elements.Player;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        gui.drawPlayer(player.getPosition());
    }
}


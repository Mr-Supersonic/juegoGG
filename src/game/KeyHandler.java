package game;

import game.game.Main;
import game.world.entity.player.Movement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyHandler implements KeyListener {
    public static HashMap<Integer, Movement> controls = new HashMap<>();

    @Override
    public void keyTyped(KeyEvent event) {
    }

    @Override
    public void keyPressed(KeyEvent event) {
        Movement movement = controls.get(event.getKeyCode());
        if (movement != null) {
            if (Main.player.getMovement().equals(Movement.NONE) || !Main.player.getMovement().equals(movement)) {
                Main.player.setKeyRelased(false);
                Main.player.setMovement(movement);
            }
            else if (Main.player.isKeyRelased()) Main.player.setMovement(Movement.NONE);
        }

    }

    @Override
    public void keyReleased(KeyEvent event) {
        Movement movement = controls.get(event.getKeyCode());
        if (movement != null && !Main.player.getMovement().equals(Movement.NONE)) {
            Main.player.setKeyRelased(true);
        }
    }
}

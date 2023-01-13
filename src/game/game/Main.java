package game.game;

import game.GamePanel;
import game.KeyHandler;
import game.world.entity.player.Movement;
import game.world.entity.player.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Main {
    public static Player player = new Player(0, 0);

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Parchís");

        GamePanel panel = new GamePanel();
        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null); //Se muestra en el centro de la pantalla
        window.setVisible(true);
        panel.startGameThread();

        KeyHandler.controls.put(KeyEvent.VK_W, Movement.FORWARDS);
        KeyHandler.controls.put(KeyEvent.VK_S, Movement.BACK);
        KeyHandler.controls.put(KeyEvent.VK_A, Movement.LEFT);
        KeyHandler.controls.put(KeyEvent.VK_D, Movement.RIGHT);
    }
}
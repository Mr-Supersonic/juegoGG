package game;

import game.game.Main;
import game.world.entity.player.Attribute;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public static final int ORIGINAL_TILE_SIZE = 16;
    public static final int SCALE = 3;
    public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;

    public static final int MAX_SCREEN_COLUMNS = 16;
    public static final int MAX_SCREEN_ROWS = 12;

    public static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COLUMNS;
    public static final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROWS;

    public static final int MAX_FPS = 60;
    public static int fps = 0;
    public static final double DRAW_INTERVAL = 1000000000.0 / MAX_FPS;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    public GamePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(new Color(135, 205, 235));
        setDoubleBuffered(true);
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        double delta = 0;
        long lastTime = System.nanoTime(), currentTime, timer = 0;
        int drawTime = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / DRAW_INTERVAL;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawTime++;
            }

            if (timer >= 1000000000) {
                fps = drawTime;
                drawTime = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        Main.player.update();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(Color.WHITE);
        graphics.drawString(String.format("FPS: %s", fps), 10, 30);
        graphics.drawString(String.format("Player position: %s, %s", Main.player.getX(), Main.player.getY()), 10, 40);

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.WHITE);
        Main.player.draw(graphics2D);
        graphics2D.dispose();
    }
}

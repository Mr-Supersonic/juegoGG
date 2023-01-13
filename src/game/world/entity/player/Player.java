package game.world.entity.player;

import game.GamePanel;
import game.game.Main;
import game.world.entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    private Movement movement = Movement.NONE;
    private boolean isKeyRelased;
    private BufferedImage[] sprite = new BufferedImage[5];
    private int animation = 0, animationDelay = 0;

    private static final int ANIMATION_DELAY = 5;

    public Player(int spawnX, int spawnY) {
        super(spawnX, spawnY);
        try {
            sprite[0] = ImageIO.read(new File("assets/textures/entity/player/player1.png"));
            sprite[1] = ImageIO.read(new File("assets/textures/entity/player/player2.png"));
            sprite[2] = ImageIO.read(new File("assets/textures/entity/player/player3.png"));
            sprite[3] = ImageIO.read(new File("assets/textures/entity/player/player4.png"));
            sprite[4] = ImageIO.read(new File("assets/textures/entity/player/player5.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        double movementSpeed = getAttribute(Attribute.MOVEMENT_SPEED);
        switch (getMovement()) {
            case FORWARDS:
                setY(getY() - movementSpeed);
                break;
            case BACK:
                setY(getY() + movementSpeed);
                break;
            case LEFT:
                setX(getX() - movementSpeed);
                break;
            case RIGHT:
                setX(getX() + movementSpeed);
                break;
        }
    }
    
    public void draw(Graphics2D graphics2D) {
        if (!movement.equals(Movement.NONE)) {
            animationDelay++;
            if (animationDelay >= ANIMATION_DELAY) {
                animationDelay = 0;
                animation++;
                if (animation >= sprite.length) animation = 0;
            }
        }
        graphics2D.drawImage(sprite[animation], (int) getX(), (int) getY(), GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, null);
    }
    
    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public boolean isKeyRelased() {
        return isKeyRelased;
    }

    public void setKeyRelased(boolean isKeyRelased) {
        this.isKeyRelased = isKeyRelased;
    }
}

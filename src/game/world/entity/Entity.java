package game.world.entity;

import game.world.entity.player.Attribute;

import java.util.HashMap;

public class Entity {
    private double x;
    private double y;
    private Facing direction;
    private HashMap<Attribute, Double> attributes = new HashMap<>();

    public Entity(int spawnX, int spawnY) {
        x = spawnX;
        y = spawnY;

        for (Attribute attribute: Attribute.values()) {
            attributes.put(attribute, attribute.getDefaultValue());
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getAttribute(Attribute attribute) {
        return attributes.getOrDefault(attribute, 0.0);
    }

    public enum Facing {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}

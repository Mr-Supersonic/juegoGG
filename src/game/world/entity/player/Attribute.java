package game.world.entity.player;

public enum Attribute {
    MOVEMENT_SPEED(1.25);

    private double defaultValue;

    private Attribute(double defaultValue) {
        this.defaultValue = defaultValue;
    }

    public double getDefaultValue() {
        return this.defaultValue;
    }
}

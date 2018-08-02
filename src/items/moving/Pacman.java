package items.moving;

import items.Sprite;

public class Pacman extends Sprite {
    private PacmanRotation rotation;

    public Pacman(int x, int y) {
        super("pacman.png", x, y, 35, 35);
    }

    public PacmanRotation getRotation() {
        return rotation;
    }

    public void setRotation(PacmanRotation rotation) {
        this.rotation = rotation;
    }
}

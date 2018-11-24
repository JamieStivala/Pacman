package pacman.items.moving.pacman;

import pacman.items.Sprite;

import java.awt.image.BufferedImage;

/**
 * Represents the moving Pacman
 */
public class Pacman extends Sprite {
    private volatile boolean collidedWithWall;
    private PacmanRotation currentRotation;
    private PacmanRotation nextRotation;

    /**
     * Spawns the object with the same texture with and height every time
     * Since the width and height of the objects are constants and even the file name this class is used for ease
     *
     * @param x-coordinate to spawn in
     * @param y-coordinate to spawn in
     */
    public Pacman(int x, int y) {
        super("pacman.png", x, y, 32, 32);
    }

    /**
     * @return The current rotation of the Pacman
     */
    public PacmanRotation getCurrentRotation() {
        return currentRotation;
    }

    /**
     * Rotates the texture of the Pacman
     * Since the rotate method only rotates at 90 degrees it has to be called more then once for the rotation to be done at 90, 180 and 240 rotations
     * @param currentRotation
     */
    public void setCurrentRotation(PacmanRotation currentRotation) {
        PacmanRotation oldRotation = this.getCurrentRotation();
        this.currentRotation = currentRotation;
        if ((oldRotation != PacmanRotation.RIGHT || currentRotation != PacmanRotation.DOWN) && (oldRotation != PacmanRotation.DOWN || currentRotation != PacmanRotation.LEFT) && (oldRotation != PacmanRotation.LEFT || currentRotation != PacmanRotation.UP) && (oldRotation != PacmanRotation.UP || currentRotation != PacmanRotation.RIGHT) && (oldRotation != null || currentRotation != PacmanRotation.DOWN)) {
            if ((oldRotation != PacmanRotation.RIGHT || currentRotation != PacmanRotation.LEFT) && (oldRotation != PacmanRotation.DOWN || currentRotation != PacmanRotation.UP) && (oldRotation != PacmanRotation.LEFT || currentRotation != PacmanRotation.RIGHT) && (oldRotation != PacmanRotation.UP || currentRotation != PacmanRotation.DOWN) && (oldRotation != null || currentRotation != PacmanRotation.LEFT)) {
                if (oldRotation == PacmanRotation.RIGHT && currentRotation == PacmanRotation.UP || oldRotation == PacmanRotation.DOWN && currentRotation == PacmanRotation.RIGHT || oldRotation == PacmanRotation.LEFT && currentRotation == PacmanRotation.DOWN || oldRotation == PacmanRotation.UP && currentRotation == PacmanRotation.LEFT || oldRotation == null && currentRotation == PacmanRotation.UP) {
                    this.rotate();
                    this.rotate();
                    this.rotate();
                }
            } else {
                this.rotate();
                this.rotate();
            }
        } else {
            this.rotate();
        }
    }

    /**
     * @return The next rotation of the pacman when it is not overlapping
     */
    public PacmanRotation getNextRotation() {
        return nextRotation;
    }

    /**
     * Sets the next rotation of the pacman when it is not overlapping
     */
    public void setNextRotation(PacmanRotation nextRotation) {
        this.nextRotation = nextRotation;
    }

    /**
     * This method rotates the BufferedImage by 90 degrees
     */
    private void rotate() {
        int flipHeight = super.getImage().getWidth();
        int flipWidth = super.getImage().getHeight();
        BufferedImage newImage = new BufferedImage(flipWidth, flipHeight, super.getImage().getType());

        for (int i = 0; i < flipHeight; i++) {
            for (int j = 0; j < flipWidth; j++) {
                newImage.setRGB(flipWidth - 1 - j, i, super.getImage().getRGB(i, j));
            }
        }

        super.image = newImage;
    }

    /**
     * @return A boolean that represents if the pacman is collided with the wall
     */
    public boolean isCollidedWithWall() {
        return collidedWithWall;
    }

    /**
     * Sets a boolean that represents if the pacman is collided with the wall
     */
    public void setCollidedWithWall(boolean collidedWithWall) {
        this.collidedWithWall = collidedWithWall;
    }
}

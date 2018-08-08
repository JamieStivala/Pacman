package items.moving;

import items.Sprite;

import java.awt.image.BufferedImage;

public class Pacman extends Sprite {
    private volatile boolean collidedWithWall;
    private PacmanRotation currentRotation;
    private PacmanRotation nextRotation;

    public Pacman(int x, int y) {
        super("pacman.png", x, y, 35, 35);
    }

    public PacmanRotation getCurrentRotation() {
        return currentRotation;
    }

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

    public PacmanRotation getNextRotation() {
        return nextRotation;
    }

    public void setNextRotation(PacmanRotation nextRotation) {
        this.nextRotation = nextRotation;
    }

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

    public boolean isCollidedWithWall() {
        return collidedWithWall;
    }

    public void setCollidedWithWall(boolean collidedWithWall) {
        this.collidedWithWall = collidedWithWall;
    }
}

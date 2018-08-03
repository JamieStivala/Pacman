package items.moving;

import items.Sprite;

import java.awt.image.BufferedImage;

public class Pacman extends Sprite {
    private boolean collidedWithWall;
    private PacmanRotation rotation;

    public Pacman(int x, int y) {
        super("pacman.png", x, y, 35, 35);
    }

    public PacmanRotation getRotation() {
        return rotation;
    }

    public void setRotation(PacmanRotation rotation) {
        PacmanRotation oldRotation = getRotation();
        this.rotation = rotation;
        if (oldRotation == PacmanRotation.RIGHT && rotation == PacmanRotation.DOWN ||
                oldRotation == PacmanRotation.DOWN && rotation == PacmanRotation.LEFT ||
                oldRotation == PacmanRotation.LEFT && rotation == PacmanRotation.UP ||
                oldRotation == PacmanRotation.UP && rotation == PacmanRotation.RIGHT ||
                oldRotation == null && rotation == PacmanRotation.DOWN){
            rotate();
        } else if(oldRotation == PacmanRotation.RIGHT && rotation == PacmanRotation.LEFT ||
                oldRotation == PacmanRotation.DOWN && rotation == PacmanRotation.UP ||
                oldRotation == PacmanRotation.LEFT && rotation == PacmanRotation.RIGHT ||
                oldRotation == PacmanRotation.UP && rotation == PacmanRotation.DOWN ||
                oldRotation == null && rotation == PacmanRotation.LEFT) {
            rotate();
            rotate();
        } else if(oldRotation == PacmanRotation.RIGHT && rotation == PacmanRotation.UP ||
                oldRotation == PacmanRotation.DOWN && rotation == PacmanRotation.RIGHT ||
                oldRotation == PacmanRotation.LEFT && rotation == PacmanRotation.DOWN ||
                oldRotation == PacmanRotation.UP && rotation == PacmanRotation.LEFT ||
                oldRotation == null && rotation == PacmanRotation.UP){
            rotate();
            rotate();
            rotate();
        }
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

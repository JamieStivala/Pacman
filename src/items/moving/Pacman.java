package items.moving;

import items.Sprite;

import java.awt.image.BufferedImage;

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

}

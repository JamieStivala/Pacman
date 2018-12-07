package game.items.stationery;

import game.items.Blob;

import java.awt.*;

public class Wall extends Blob {
    /**
     * Spawns the object with the same texture with and height every time
     * Since the width and height of the objects are constants and even the file name this class is used for ease
     *
     * @param x-coordinate to spawn in
     * @param y-coordinate to spawn in
     */
    public Wall(int x, int y) {
        super("wall.png", x, y, 40, 40);
    }

    @Override
    public void paint(Graphics g) {
        if (!this.isVisible()) return;
        g.drawImage(getImage(), getBlockMiddle()[0], getBlockMiddle()[1], (int) getArea().getWidth(), (int) getArea().getHeight(), null);
    }
}

package game.items.stationery;

import game.items.Blob;
import java.awt.image.BufferedImage;

public class Wall extends Blob {
    /**
     * Spawns the object with the same texture with and height every time
     * Since the width and height of the objects are constants and even the file name this class is used for ease
     *
     * @param x-coordinate to spawn in
     * @param y-coordinate to spawn in
     */
    public Wall(BufferedImage wall, int x, int y) {
        super(wall, x, y, getMaxWidth(), getMaxHeight());
    }
}

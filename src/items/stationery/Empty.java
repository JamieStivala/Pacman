package items.stationery;

import items.Blob;

/**
 * This class resents the one Empty block
 */
public class Empty extends Blob {
    /**
     * Spawns the object with the same texture with and height every time
     * Since the width and height of the objects are constants and even the file name this class is used for ease
     *
     * @param x-coordinate to spawn in
     * @param y-coordinate to spawn in
     */
    public Empty(int x, int y) {
        super(null, x, y, 0, 0);
    }
}

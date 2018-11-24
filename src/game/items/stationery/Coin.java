package game.items.stationery;

import game.items.Blob;

/**
 * This class resents the one Coin
 */
public class Coin extends Blob {
    /**
     * Spawns the object with the same texture with and height every time
     * Since the width and height of the objects are constants and even the file name this class is used for ease
     *
     * @param x-coordinate to spawn in
     * @param y-coordinate to spawn in
     */
    public Coin(int x, int y) {
        super("coin.png", x + 12, y + 12, 10, 10); // The x and y have plus 12 for the coins to spawn in the middle
    }
}

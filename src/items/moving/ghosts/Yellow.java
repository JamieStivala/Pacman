package items.moving.ghosts;

/**
 * This class resents the yellow ghost
 */
public class Yellow extends Ghost {
    /**
     * Spawns the object with the same texture with and height every time
     * Since the width and height of the objects are constants and even the file name this class is used for ease
     *
     * @param x-coordinate to spawn in
     * @param y-coordinate to spawn in
     */
    public Yellow(int x, int y) {
        super("yellow.png", x, y, 32, 32);
    }
}

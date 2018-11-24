package game.items.moving.ghosts;

/**
 * This class resents the pink ghost
 */
public class Pink extends Ghost {
    /**
     * Spawns the object with the same texture with and height every time
     * Since the width and height of the objects are constants and even the file name this class is used for ease
     *
     * @param x-coordinate to spawn in
     * @param y-coordinate to spawn in
     */
    public Pink(int x, int y) {
        super("pink.png", x, y, 32, 32);
    }
}

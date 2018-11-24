package game.items;

/**
 * Represents all the moving objects
 * This extends the class Blob
 */
public class Sprite extends Blob {
    /**
     * It calls the constructor of the Blob
     *
     * @param filename The resource file name of the Blob
     * @param x The spawning x coordinate
     * @param y The spawning y coordinate
     * @param width The width of the resource
     * @param height The height of the resource
     */
    public Sprite(String filename, int x, int y, int width, int height) {
        super(filename, x, y, width, height);
    }

    /**
     * @param pixels By how much pixels to move to the left
     */
    public void moveLeft(int pixels) {
        super.getArea().setLocation((int) (super.getArea().getX()) - pixels, (int) super.getArea().getY());
    }

    /**
     * @param pixels By how much pixels to move to the right
     */
    public void moveRight(int pixels) {
        super.getArea().setLocation((int) (super.getArea().getX()) + pixels, (int) super.getArea().getY());
    }

    /**
     * @param pixels By how much pixels to move up
     */
    public void moveUp(int pixels) {
        super.getArea().setLocation((int) (super.getArea().getX()), (int) super.getArea().getY() - pixels);
    }

    /**
     * @param pixels By how much pixels to move down
     */
    public void moveDown(int pixels) {
        super.getArea().setLocation((int) (super.getArea().getX()), (int) super.getArea().getY() + pixels);
    }
}

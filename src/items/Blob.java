package items;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * This class represents the a stationery objects inside the Game
 */

public class Blob {
    protected BufferedImage image;
    private Rectangle area;
    private boolean visible;

    /*
     * This method starts by creating loading the specified texture (from the resource folder) to the class unless the filename is null.
     * Afterwards it creates a Rectangle that represents the area of the object.  That will be used to check if something is collided with other thing
     *
     * @param filename The resource file name of the Blob
     * @param x The spawning x coordinate
     * @param y The spawning y coordinate
     * @param width The width of the resource
     * @param height The height of the resource
     */
    public Blob(String filename, int x, int y, int width, int height) {
        if (filename != null) {
            try {
                image = ImageIO.read(new File("resources/game/" + filename));
            } catch (Exception e) {
                System.out.println("Error loading: " + filename);
            }
        }

        area = new Rectangle(x, y, width, height);
        visible = true;
    }

    /**
     * @return A boolean stating if the object is visible
     */
    private boolean isVisible() {
        return visible;
    }

    /**
     * @param v A boolean that sets the visibility of the object
     */
    public void setVisible(boolean v) {
        this.visible = v;
    }

    /**
     * Used to check if two Blobs have collided
     * This method first checks if the blob is visible and If visible it will use the Rectangle "intersects" to check if a blob intersects another Blob.
     * @param other The other blob that it has to check
     * @return If the two objects are collided
     */
    public boolean hasCollidedWith(Blob other) {
        return isVisible() && this.area.intersects(other.getArea());
    }

    /**
     * @return The Rectangle (area) of the object
     */
    public Rectangle getArea() {
        return area;
    }

    /**
     * @return The x-coordinate of the object
     */
    public int getX() {
        return (int) area.getX();
    }

    /**
     * @return The y-coordinate of the object
     */
    public int getY() {
        return (int) area.getY();
    }

    /**
     * @return The image of the object
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * This will be used to paint the resource in the specified Graphics.  If the object is not visible it doesn't draw.
     * @param g The graphics of java.awt
     */
    public void paint(Graphics g) {
        if (!visible) return;
        g.drawImage(getImage(), (int) area.getX(), (int) area.getY(), (int) area.getWidth(), (int) area.getHeight(), null);
    }

}

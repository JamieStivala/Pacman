package items;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Blob{
    private boolean visible;
    private BufferedImage resourceName;
    private Rectangle area;

    public Blob(String resourceName, String format, boolean visible, int x, int y, int width, int height){
        try {
            this.resourceName = ImageIO.read(new File(resourceName + "." + format));
        }catch (IOException ex){
            System.err.println("Unable to find resource"); //-- To be changed to a graphical error.
        }
        area = new Rectangle(x, y, width, height);
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public BufferedImage getResourceName() {
        return resourceName;
    }

    public void setResourceName(BufferedImage resourceName) {
        this.resourceName = resourceName;
    }

    public Rectangle getArea() {
        return area;
    }

    public void setArea(Rectangle area) {
        this.area = area;
    }
}

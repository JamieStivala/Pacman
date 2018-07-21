package items;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Blob{
    private boolean visible;
    protected BufferedImage resource;
    Rectangle area;

    public Blob(String resourceName, String format, boolean visible, int x, int y, int width, int height){
        try {
            this.resource = ImageIO.read(new File("resources/" + resourceName + "." + format));
        }catch (IOException ex){
            System.err.println("Unable to find resource: " + resourceName); //-- To be changed to a graphical error.
        }

        this.area = new Rectangle(x, y, width, height);
        this.visible = visible;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public BufferedImage getResource() {
        return this.resource;
    }

    public void setResource(BufferedImage resource) {
        this.resource = resource;
    }

    public int getX(){
        return this.area.x;
    }

    public int getY(){
        return this.area.y;
    }

    public int getWidth(){
        return this.area.width;
    }

    public int getHeight(){
        return this.area.height;
    }

    public void paint (Graphics g){
        if (isVisible()){
            g.drawImage (resource, this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
        }
    }
}

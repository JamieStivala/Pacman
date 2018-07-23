package items;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Blob {
    private BufferedImage image;
    private Rectangle area;
    private boolean visible;

    public Blob (String filename, int x, int y, int width, int height) {
        try {
            image = ImageIO.read(new File("resources/" + filename));
        } catch (Exception e) {
            System.out.println("Error loading: " + filename);
        }

        area = new Rectangle (x, y, width, height);
        visible = true;
    }

    boolean isVisible (){
        return visible;
    }

    void setVisible (boolean v){
        this.visible = v;
    }

    public boolean hasCollidedWith (Blob other){
        return this.area.intersects (other.getArea());
    }

    Rectangle getArea(){
        return area;
    }

    public int getX(){
        return (int) area.getX();
    }

    public int getY(){
        return (int) area.getY();
    }

    public BufferedImage getImage(){
        return image;
    }

    public void paint(Graphics g) {
        if(!visible) return;
        g.drawImage (getImage(), (int)area.getX(), (int)area.getY(), (int)area.getWidth(), (int)area.getHeight(), null);
    }

}
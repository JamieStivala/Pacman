package items;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Sprite{
    private BufferedImage image;
    private Rectangle area;
    private boolean visible;

    Sprite (String filename, int x, int y, int w, int h){
        try{
            image = ImageIO.read (new File ("src/Lesson14/" + filename));
        }catch(Exception e){
            System.out.println("Error loading: " + filename);
        }

        area = new Rectangle (x, y, w, h);
        visible = true;
    }

    boolean isVisible (){
        return visible;
    }

    void setVisible (boolean v){
        this.visible = v;
    }

    void moveLeft (int pixels){
        area.setLocation ((int) (area.getX()) - pixels, (int)area.getY());
    }

    void moveRight (int pixels){
        area.setLocation ((int) (area.getX()) + pixels, (int)area.getY());
    }

    public void moveUp (int pixels){
        area.setLocation ((int) (area.getX()), (int)area.getY() - pixels);
    }

    void moveDown (int pixels){
        area.setLocation ((int) (area.getX()), (int)area.getY() + pixels);
    }

    public boolean hasCollidedWith (Sprite other){
        return this.area.intersects (other.getArea());
    }

    private Rectangle getArea(){
        return area;
    }

    public int getX(){
        return (int) area.getX();
    }

    public int getY(){
        return (int) area.getY();
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    public BufferedImage getImage(){
        return image;
    }

    void paint(Graphics g) {
        if(!visible) return;
        g.drawImage (image, (int)area.getX(), (int)area.getY(), (int)area.getWidth(), (int)area.getHeight(), null);
    }
}

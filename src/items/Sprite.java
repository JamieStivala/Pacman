package items;

public class Sprite extends Blob{
    public Sprite(String resourceName, String format, boolean visible, int x, int y, int width, int height) {
        super(resourceName, format, visible, x, y, width, height);
    }

    public void setX(int x){
        area.setLocation(x, getY());
    }

    public void setY(int y){
        area.setLocation(getX(), y);
    }

    public void setWidth(int width){
        area.setSize(width, getHeight());
    }

    public void setHeight(int height){
        area.setSize(getWidth(), height);
    }

    public void moveLeft(int pixels){
        area.setLocation(getX() - pixels, getY());
    }

    public void moveRight(int pixels){
        area.setLocation(getX() + pixels, getY());
    }

    public void moveUp(int pixels){
        area.setLocation(getX(), getY() + pixels);
    }
    public void moveDown(int pixels){
        area.setLocation(getX(), getY() - pixels);
    }

    public boolean hasCollided(Sprite sprite){
        return this.area.intersects(sprite.area);
    }
}

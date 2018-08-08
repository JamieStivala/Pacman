package items;

public class Sprite extends Blob {
    public Sprite(String filename, int x, int y, int width, int height) {
        super(filename, x, y, width, height);
    }

    public void moveLeft(int pixels) {
        super.getArea().setLocation((int) (super.getArea().getX()) - pixels, (int) super.getArea().getY());
    }

    public void moveRight(int pixels) {
        super.getArea().setLocation((int) (super.getArea().getX()) + pixels, (int) super.getArea().getY());
    }

    public void moveUp(int pixels) {
        super.getArea().setLocation((int) (super.getArea().getX()), (int) super.getArea().getY() - pixels);
    }

    public void moveDown(int pixels) {
        super.getArea().setLocation((int) (super.getArea().getX()), (int) super.getArea().getY() + pixels);
    }
}

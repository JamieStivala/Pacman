package pacman.map;

/**
 * Due to the lack of line class in java this was created.  This will be used to store lines used in graphics.drawLine()
 */
public class Line {
    private int x;
    private int y;
    private int x1;
    private int y1;

    Line(int x, int y, int x1, int y1) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }
}

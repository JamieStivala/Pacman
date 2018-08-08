package items.moving.ghosts;

import java.awt.*;

public class Ghosts {
    private Pink pink;
    private Red red;
    private Turquoise turquoise;
    private Yellow yellow;

    public Ghosts(){
        red = new Red(720, 360);
        pink = new Pink(720, 380);
        turquoise = new Turquoise(720, 400);
        yellow = new Yellow(720, 410);
    }

    public Pink getPink() {
        return pink;
    }

    public Red getRed() {
        return red;
    }

    public Turquoise getTurquoise() {
        return turquoise;
    }

    public Yellow getYellow() {
        return yellow;
    }

    public void paint(Graphics g){
        red.paint(g);
        pink.paint(g);
        turquoise.paint(g);
        yellow.paint(g);
    }
}

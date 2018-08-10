package items.moving.ghosts;

import java.awt.*;

public class Ghosts {
    private Pink pink;
    private Red red;
    private Turquoise turquoise;
    private Yellow yellow;

    private Ghost ghosts[];
    private int amountOfGhostsOut;

    public Ghosts(){
        red = new Red(720, 360);
        pink = new Pink(685, 375);
        turquoise = new Turquoise(765, 375);
        yellow = new Yellow(720, 410);

        ghosts = new Ghost[4];
        ghosts[0] = red;
        ghosts[1] = pink;
        ghosts[2] = turquoise;
        ghosts[3] = yellow;

        this.amountOfGhostsOut = 1;
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

    public int getAmountOfGhostsOut() {
        return amountOfGhostsOut;
    }

    public void setAmountOfGhostsOut(int amountOfGhostsOut) {
        this.amountOfGhostsOut = amountOfGhostsOut;
    }

    public Ghost[] getGhosts() {
        return ghosts;
    }
}

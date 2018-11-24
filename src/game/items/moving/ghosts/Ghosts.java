package game.items.moving.ghosts;

import java.awt.*;

/**
 * This class is a wrapper of all the coloured ghosts so that everything is sorted in one class
 */
public class Ghosts {
    private Pink pink;
    private Red red;
    private Turquoise turquoise;
    private Yellow yellow;

    private Ghost ghosts[];
    private int amountOfGhostsOut;

    /**
     * This creates the instances of all the ghosts and creates an array with all the ghosts in it
     * Also sets the amountOfGhostsOut to one
     */
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

    /**
     * @return Pink ghost
     */
    public Pink getPink() {
        return pink;
    }

    /**
     * @return Red ghosts
     */
    public Red getRed() {
        return red;
    }

    /**
     * @return Turquoise ghost
     */
    public Turquoise getTurquoise() {
        return turquoise;
    }

    /**
    * @return Yellow ghost
     */
    public Yellow getYellow() {
        return yellow;
    }

    /**
     * Paints the ghost on the given graphics
     * @param g The graphics of java.awt
     */
    public void paint(Graphics g){
        red.paint(g);
        pink.paint(g);
        turquoise.paint(g);
        yellow.paint(g);
    }

    /**
     * @return The amount of ghosts currently moving
     */
    public int getAmountOfGhostsOut() {
        return amountOfGhostsOut;
    }

    /**
     * @param amountOfGhostsOut Sets the amount of ghosts currently moving
     */
    public void setAmountOfGhostsOut(int amountOfGhostsOut) {
        this.amountOfGhostsOut = amountOfGhostsOut;
    }

    /**
     * @return All the ghosts in one array
     */
    public Ghost[] getGhosts() {
        return ghosts;
    }
}

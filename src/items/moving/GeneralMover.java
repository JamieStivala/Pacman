package items.moving;

import astar.Node;
import frames.PacmanFrame;
import items.moving.ghosts.Ghost;
import items.moving.ghosts.Ghosts;
import items.moving.ghosts.threads.GhostsCalculator;
import items.moving.pacman.Pacman;
import items.moving.pacman.PacmanRotation;

/**
 * Represents the general moving and renderer of each object that is moving such as the ghosts and the pacman.
 * This is a all done in a separate thread for efficiency
 */
public class GeneralMover extends Thread {
    private PacmanFrame pacmanFrame;
    private Pacman pacman;
    private Ghosts ghosts;
    private double freqOfMoves = 0;

    /**
     * @param pacmanFrame The object of the pacmanFrame which stores most of the objects regarding the game
     */
    public GeneralMover(PacmanFrame pacmanFrame) {
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
        this.ghosts = pacmanFrame.getGhosts();
    }

    @Override
    public void run() {
        while (pacmanFrame.isRunning()) {
            doPacmanMove(pacmanFrame.getPacman().getCurrentRotation());
            renderCoins();
            moveGhosts(0, ghosts.getGhosts());
            pacmanFrame.render();
            pacmanFrame.repaint();
            try {
                Thread.sleep(105);
            } catch (InterruptedException e) {
                System.err.println("Interrupted exception: " + e.getMessage());
            }
        }
    }

    /**
     * Will constantly move the pacman by 6 pixels depending on the rotation given unless collided with wall.
     * This also handles the teleportation from one side of the screen to another.
     *
     * This method also increments freqOfMoves that handles when the ghosts can move.
     * @param rotation The rotation the pacman currently is in
     */
    private void doPacmanMove(PacmanRotation rotation) {
        if (pacman.getX() < -5 && rotation == PacmanRotation.LEFT) {
            pacman.getArea().setLocation(1423, pacman.getY());
        } else if (pacman.getX() > 1423 && rotation == PacmanRotation.RIGHT) {
            pacman.getArea().setLocation(-5, pacman.getY());
        } else if (pacman.getY() < 17 && rotation == PacmanRotation.UP) {
            pacman.getArea().setLocation(pacman.getX(), 782);
        } else if (pacman.getY() > 782 && rotation == PacmanRotation.DOWN) {
            pacman.getArea().setLocation(pacman.getX(), 17);
        } else if (!pacman.isCollidedWithWall()) {
            if (rotation == PacmanRotation.LEFT) pacman.moveLeft(6);
            else if (rotation == PacmanRotation.RIGHT) pacman.moveRight(6);
            else if (rotation == PacmanRotation.UP) {
                pacman.moveUp(6);
                freqOfMoves += 0.5;
            }
            else if (rotation == PacmanRotation.DOWN){
                pacman.moveDown(6);
                freqOfMoves += 0.5;
            }
        }
        freqOfMoves++;
    }

    /**
     * This moves a ghost to a specified location when the pacman moves one block and also calculates the PathFinding in a separate thread
     * @param counter This counter is used to check if the recursion is finished
     * @param ghost The ghost that is to be moved
     */
    private void moveGhost(int counter, Ghost ghost) {
        if(counter == 0) new GhostsCalculator(this.pacmanFrame).start();
        if(freqOfMoves <= 6) return;

        if (ghost.getPath() == null || ghost.getPath().isEmpty())
            return;

        int nextPosition[] = getCoordinatesFromPosition(ghost.getPath().get(ghost.getChanged()));
        ghost.getArea().setLocation(nextPosition[0], nextPosition[1]);

        if(counter == 3) freqOfMoves = 0;
    }

    /**
     * Used to move all the ghosts
     * @param counter Used as a counter in recursion
     * @param ghosts The array of all the ghosts
     */
    private void moveGhosts(int counter, Ghost[] ghosts){
        if(counter == ghosts.length) return;
        moveGhost(counter, ghosts[counter]);
        moveGhosts(++counter, ghosts);
    }

    /**
     * This is a method used to check if any coins have been taken.  If a coin has been take the whole map os updated and also
     * triggers a variable that shows that all the coins have been updated.
     */
    private void renderCoins() {
        if (pacmanFrame.getCoinCollisionDetection().hasCoinBeenTaken()) {
            pacmanFrame.getMap().paint();
            pacmanFrame.getCoinCollisionDetection().updatedCoins();
        }
    }

    /**
     * This class converts the numbers from the A* grid to actual coordinates
     * @param x The Node
     * @return The horizontal and vertical position of the ghosts next position
     */
    private int[] getCoordinatesFromPosition(Node x) {
        int h = x.getRow() * 36; //X
        int v = (x.getCol() * 39) + 20; //Y
        return new int[]{h, v};
    }
}

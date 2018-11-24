package pacman.items.moving.pacman.threads;

import pacman.frame.PacmanFrame;
import pacman.items.moving.pacman.Pacman;
import pacman.map.Line;

import static pacman.items.moving.pacman.PacmanRotation.*;

/**
 * Checks whether or not the Pacman can rotate
 * This is done is a separate thread for efficiency
 */
public class OverlappingDetection extends Thread {
    private PacmanFrame pacmanFrame;
    private Pacman pacman;

    /**
     * @param pacmanFrame The pacman frame that has almost all the objects of the Pacman
     */
    public OverlappingDetection(PacmanFrame pacmanFrame) {
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
    }

    /**
     * Constantly checks if the Pacman has collided with the specified rotate lines.
     *
     * In PacmanMap an array of Line.  This Line is a grid that represents how big each block should be (including the empty).
     * Whenever the pacman is overlapping the lines of the grid, it means that it can't rotate
     *
     * When the Pacman is not overlapping the grid, the pacman rotates to the next rotation
     */
    @Override
    public void run() {
        while (pacmanFrame.isRunning()) {
            boolean overlaps = false;

            if ((pacman.getCurrentRotation() == LEFT || pacman.getCurrentRotation() == RIGHT) && (pacman.getNextRotation() == UP || pacman.getNextRotation() == DOWN)) {
                for (Line current : pacmanFrame.getMap().getVerticalWallLines()) {
                    if (pacman.getArea().intersectsLine(current.getX(), current.getY(), current.getX1(), current.getY1())) {
                        overlaps = true;
                    }
                }
            } else if ((pacman.getCurrentRotation() == UP || pacman.getCurrentRotation() == DOWN) && (pacman.getNextRotation() == LEFT || pacman.getNextRotation() == RIGHT)) {
                for (Line current : pacmanFrame.getMap().getHorizontalWallLines()) {
                    if (pacman.getArea().intersectsLine(current.getX(), current.getY(), current.getX1(), current.getY1())) {
                        overlaps = true;
                    }
                }
            }

            if (!overlaps || pacman.isCollidedWithWall()) {
                pacman.setCurrentRotation(pacman.getNextRotation());
            }
        }

    }
}

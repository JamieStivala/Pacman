package items.moving.pacman.threads;

import frames.PacmanFrame;
import items.Blob;
import items.moving.pacman.Pacman;
import items.moving.pacman.PacmanRotation;
import map.BlockType;

import java.util.ArrayList;

/**
 * Checks if the pacman has collided with the wall.
 * This is done is a separate thread for efficiency
 */
public class WallCollisionDetection extends Thread {
    private PacmanFrame frame;
    private Pacman pacman;
    private volatile boolean keyPressedSinceCollision = false;

    /**
     * @param frame The pacman frame that has almost all the objects of the Pacman
     */
    public WallCollisionDetection(PacmanFrame frame) {
        this.frame = frame;
        this.pacman = frame.getPacman();
    }

    /**
     * The thread that consistently checks if the pacman is collided with the wall
     *
     * Since the pacman moves at 6 pixels I couldn't just use the area.isCollidedWith since this would check the whole block.  When checking
     * the whole block it sometimes found that the pacman is inside the block and when pressing the next button it would still be "collided" and the Pacman wouldn't move.
     *
     * The solution to this was creating custom lines for each block and on the x and y plane and checking if the Pacman collides with them.
     *
     * The lines are slightly cut in length and also have a they are slightly suspended outwards.
     */
    @Override
    public void run() {
        while (frame.isRunning()) {
            ArrayList<Blob> walls = frame.getMap().getOrganizedBlocks().get(BlockType.WALL);
            for (Blob blob : walls) {
                if (keyPressedSinceCollision) {
                    if (pacman.getCurrentRotation() == PacmanRotation.RIGHT && pacman.getArea().intersectsLine(blob.getX(), blob.getY() + 4, blob.getX(), blob.getY() + blob.getArea().height - 4)) {
                        pacman.setCollidedWithWall(true);
                        keyPressedSinceCollision = false;
                    } else if (pacman.getCurrentRotation() == PacmanRotation.LEFT && pacman.getArea().intersectsLine(blob.getX() + 6 + blob.getArea().width, blob.getY() + 4, blob.getX() + 6 + blob.getArea().width, blob.getY() + blob.getArea().height - 4)) {
                        pacman.setCollidedWithWall(true);
                        keyPressedSinceCollision = false;
                    } else if (pacman.getCurrentRotation() == PacmanRotation.DOWN && pacman.getArea().intersectsLine(blob.getX() + 4, blob.getY() - 2, blob.getX() + blob.getArea().width - 4, blob.getY() - 2)) {
                        pacman.setCollidedWithWall(true);
                        keyPressedSinceCollision = false;
                    } else if (pacman.getCurrentRotation() == PacmanRotation.UP && pacman.getArea().intersectsLine(blob.getX() + 6, blob.getY() + blob.getArea().height + 4, blob.getX() + blob.getArea().width - 6, blob.getY() + blob.getArea().height + 6)) {
                        pacman.setCollidedWithWall(true);
                        keyPressedSinceCollision = false;
                    } else {
                        pacman.setCollidedWithWall(false);
                    }
                }
            }
            sleep();
        }
    }

    /**
     * A sleep method so that the code looks nicer without try{} catch() in the middle of the run
     *
     * This sleep was implemented since the Pacman moves at intervals of 105 milliseconds
     */
    private void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.err.println("Interrupted exception: " + e.getMessage());
        }
    }

    /**
     * When collided with the wall, it doesn't keep on checking if it's collided until the user presses a button
     * This is the trigger to that variable
     */
    public void keyPressed() {
        this.keyPressedSinceCollision = true;
    }
}

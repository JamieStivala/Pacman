package items.moving.pacman.threads;

import frames.PacmanFrame;
import items.Blob;
import items.moving.pacman.Pacman;
import items.moving.pacman.PacmanRotation;
import map.BlockType;

import java.util.ArrayList;

public class WallCollisionDetection extends Thread {
    private PacmanFrame frame;
    private Pacman pacman;
    private volatile boolean keyPressedSinceCollision = false;

    public WallCollisionDetection(PacmanFrame frame) {
        this.frame = frame;
        this.pacman = frame.getPacman();
    }

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

    private void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.err.println("Interrupted exception: " + e.getMessage());
        }
    }

    public void keyPressed() {
        this.keyPressedSinceCollision = true;
    }
}

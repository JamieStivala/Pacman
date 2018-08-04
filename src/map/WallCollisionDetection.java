package map;

import frames.PacmanFrame;
import items.Blob;
import items.moving.Pacman;
import items.moving.PacmanRotation;

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
                if(keyPressedSinceCollision) {
                    if (pacman.getRotation() == PacmanRotation.RIGHT && pacman.getArea().intersectsLine(blob.getX() - 2, blob.getY() + 4, blob.getX() - 2, blob.getY() + blob.getArea().height - 4)) {
                        pacman.setCollidedWithWall(true);
                        keyPressedSinceCollision = false;
                    } else if (pacman.getRotation() == PacmanRotation.LEFT && pacman.getArea().intersectsLine(blob.getX() + blob.getArea().width + 2, blob.getY() + 4, blob.getX() + blob.getArea().width +  2, blob.getY() + blob.getArea().height - 4)) {
                        pacman.setCollidedWithWall(true);
                        keyPressedSinceCollision = false;
                    } else if (pacman.getRotation() == PacmanRotation.DOWN && pacman.getArea().intersectsLine(blob.getX() + 4, blob.getY() - 2, blob.getX() + blob.getArea().width - 4, blob.getY() - 2)) {
                        pacman.setCollidedWithWall(true);
                        keyPressedSinceCollision = false;
                    } else if (pacman.getRotation() == PacmanRotation.UP && pacman.getArea().intersectsLine(blob.getX() + 4, blob.getY() + blob.getArea().height + 2, blob.getX() + blob.getArea().width - 4, blob.getY() + blob.getArea().height + 2)) {
                        pacman.setCollidedWithWall(true);
                        keyPressedSinceCollision = false;
                    }else {
                        pacman.setCollidedWithWall(false);
                    }
                }
            }
        }
    }

    public void keyPressed() {
        this.keyPressedSinceCollision = true;
    }
}

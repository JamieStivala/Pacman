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
        System.out.println(keyPressedSinceCollision);
        while (frame.isRunning()) {
            ArrayList<Blob> wall = frame.getMap().getOrganizedBlocks().get(BlockType.WALL);
            for (Blob blob : wall) {

                if(!keyPressedSinceCollision || pacman.hasCollidedWith(blob)) {
                    if(pacman.getRotation() == PacmanRotation.RIGHT && blob.getX() > pacman.getX()) {
                        keyPressedSinceCollision = false;
                        pacman.setCollidedWithWall(true);
                    }else if (pacman.getRotation() == PacmanRotation.LEFT && pacman.getX() > blob.getX()){
                        keyPressedSinceCollision = false;
                        pacman.setCollidedWithWall(true);
                    }
                }else {
                    pacman.setCollidedWithWall(false);
                }
            }
        }
    }

    public void keyPressed() {
        this.keyPressedSinceCollision = true;
    }
}

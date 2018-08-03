package map;

import frames.PacmanFrame;
import items.Blob;
import items.moving.Pacman;

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
            ArrayList<Blob> wall = frame.getMap().getOrganizedBlocks().get(BlockType.WALL);
            for (Blob blob : wall) {

                if(!pacman.hasCollidedWith(blob)) {
                    System.out.println(pacman.getArea().x + " " + pacman.getArea().y);
                    System.out.println(blob.getArea().x + " " + blob.getArea().y);
                    System.out.println("\n\n\n\n");
                }
            }
        }
    }

    public void keyPressed() {
        this.keyPressedSinceCollision = true;
    }
}

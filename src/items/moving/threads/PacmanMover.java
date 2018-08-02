package items.moving.threads;

import frames.pacman.PacmanFrame;
import items.moving.Pacman;
import items.moving.PacmanRotation;

public class PacmanMover extends Thread{
    private PacmanFrame pacmanFrame;
    private Pacman pacman;

    public PacmanMover(PacmanFrame pacmanFrame){
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
    }

    @Override
    public void run() {
        while(pacmanFrame.isRunning()) {
            PacmanRotation rotation = pacmanFrame.getPacman().getRotation();
            if(rotation == PacmanRotation.LEFT) pacman.moveLeft(5);
            else if(rotation == PacmanRotation.RIGHT) pacman.moveRight(5);
            else if(rotation == PacmanRotation.UP) pacman.moveUp(5);
            else if(rotation == PacmanRotation.DOWN) pacman.moveDown(5);

            pacmanFrame.render();
            pacmanFrame.repaint();
            try{
                Thread.sleep(105);
            }catch (InterruptedException e){
                System.err.println("Interrupted exception: " + e.getMessage());
            }
        }
    }
}

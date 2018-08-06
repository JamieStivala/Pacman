package items.moving.threads;

import frames.PacmanFrame;
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
            System.out.println(pacman.getY());
            if(pacman.getX() < 0 && rotation == PacmanRotation.LEFT){
                pacman.getArea().setLocation(1440, pacman.getY());
            }else if(pacman.getX() > 1440 && rotation == PacmanRotation.RIGHT){
                pacman.getArea().setLocation(-10 , pacman.getY());
            }else if(pacman.getY() < 0 && rotation == PacmanRotation.UP){
                pacman.getArea().setLocation(pacman.getX(), 799);
            }else if(pacman.getY() > 799 && rotation == PacmanRotation.DOWN){
                pacman.getArea().setLocation(pacman.getX(), 0);
            }else if(!pacman.isCollidedWithWall()) {
                if (rotation == PacmanRotation.LEFT) pacman.moveLeft(5);
                else if (rotation == PacmanRotation.RIGHT) pacman.moveRight(5);
                else if (rotation == PacmanRotation.UP) pacman.moveUp(5);
                else if (rotation == PacmanRotation.DOWN) pacman.moveDown(5);
            }

            if(pacmanFrame.getCoinCollisionDetection().hasCoinBeenTaken()) {
                pacmanFrame.getMap().paint();
                pacmanFrame.getCoinCollisionDetection().updatedCoins();
            }
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

package items.moving.threads;

import frames.PacmanFrame;
import items.moving.Pacman;
import items.moving.PacmanRotation;

public class PacmanMover extends Thread{
    private PacmanFrame pacmanFrame;
    private Pacman pacman;
    private int amountMovedOnX;
    private int amountMovedOnY;

    public PacmanMover(PacmanFrame pacmanFrame){
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
    }

    @Override
    public void run() {
        while(pacmanFrame.isRunning()) {
            PacmanRotation rotation = pacmanFrame.getPacman().getCurrentRotation();
            if(amountMovedOnX % 36 == 0 && pacman.getX() != 0){
                System.out.println(pacman.getX());
            }
            if(pacman.getX() < -5 && rotation == PacmanRotation.LEFT){
                pacman.getArea().setLocation(1423, pacman.getY());
            }else if(pacman.getX() > 1423 && rotation == PacmanRotation.RIGHT){
                pacman.getArea().setLocation(-5 , pacman.getY());
            }else if(pacman.getY() < 17 && rotation == PacmanRotation.UP){
                pacman.getArea().setLocation(pacman.getX(), 782);
            }else if(pacman.getY() > 782 && rotation == PacmanRotation.DOWN){
                pacman.getArea().setLocation(pacman.getX(), 17);
            }else if(!pacman.isCollidedWithWall()) {
                if (rotation == PacmanRotation.LEFT) {
                    pacman.moveLeft(6);
                    amountMovedOnX +=6;
                } else if (rotation == PacmanRotation.RIGHT) {
                    pacman.moveRight(6);
                    amountMovedOnX +=6;
                } else if (rotation == PacmanRotation.UP) {
                    pacman.moveUp(6);
                    amountMovedOnY += 6;
                } else if (rotation == PacmanRotation.DOWN) {
                    pacman.moveDown(6);
                    amountMovedOnY += 6;
                }
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

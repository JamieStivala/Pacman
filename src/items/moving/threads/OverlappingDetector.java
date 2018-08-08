package items.moving.threads;

import frames.PacmanFrame;
import items.moving.Pacman;
import map.Line;

import static items.moving.PacmanRotation.*;

public class OverlappingDetector extends Thread{
    private PacmanFrame pacmanFrame;
    private Pacman pacman;

    public OverlappingDetector(PacmanFrame pacmanFrame){
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
    }

    @Override
    public void run(){
        while(pacmanFrame.isRunning()){
            if(pacman.getCurrentRotation() == LEFT || pacman.getCurrentRotation() == RIGHT && pacman.getNextRotation() == UP || pacman.getNextRotation() == DOWN){
                for (Line current: pacmanFrame.getMap().getVerticalWallLines()) {
                    if(!pacman.getArea().intersectsLine(current.getX(), current.getY(), current.getX1(), current.getY1())){
                        pacman.setCurrentRotation(pacman.getNextRotation());
                    }
                }
            } else if(pacman.getCurrentRotation() == UP || pacman.getCurrentRotation() == DOWN && pacman.getNextRotation() == LEFT || pacman.getNextRotation() == RIGHT){
                for (Line current: pacmanFrame.getMap().getHorizontalWallLines()) {
                    if(!pacman.getArea().intersectsLine(current.getX(), current.getY(), current.getX1(), current.getY1())){
                        pacman.setCurrentRotation(pacman.getNextRotation());
                    }
                }
            }else{
                pacman.setCurrentRotation(pacman.getNextRotation());
            }
        }
    }
}

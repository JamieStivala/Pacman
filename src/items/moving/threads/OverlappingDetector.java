package items.moving.threads;

import frames.PacmanFrame;
import items.moving.Pacman;

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
            //stuff
        }
    }
}

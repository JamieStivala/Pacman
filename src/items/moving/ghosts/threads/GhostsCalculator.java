package items.moving.ghosts.threads;

import frames.PacmanFrame;
import items.moving.ghosts.Ghosts;
import items.moving.pacman.Pacman;

public class GhostsCalculator extends Thread {
    private Ghosts ghosts;
    private Pacman pacman;
    private int wallArray[][];

    public GhostsCalculator(PacmanFrame pacmanFrame){
        this.pacman = pacmanFrame.getPacman();
        this.ghosts = pacmanFrame.getGhosts();
        this.wallArray = pacmanFrame.getMap().getWallArray();
    }

    @Override
    public void run(){

    }

    private int[] getPositionFromCoordinates(){
        int h = pacman.getX()/36; //X
        int v = ((pacman.getY() - 20) /39); //Y
        return new int[]{h, v};
    }
}

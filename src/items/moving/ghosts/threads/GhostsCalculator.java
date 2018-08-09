package items.moving.ghosts.threads;

import astar.AStar;
import frames.PacmanFrame;
import items.moving.ghosts.Ghosts;
import items.moving.pacman.Pacman;

public class GhostsCalculator extends Thread {
    private Ghosts ghosts;
    private Pacman pacman;
    private AStar aStar;

    public GhostsCalculator(PacmanFrame pacmanFrame){
        this.pacman = pacmanFrame.getPacman();
        this.ghosts = pacmanFrame.getGhosts();
        this.aStar = pacmanFrame.getAStar();
    }
}

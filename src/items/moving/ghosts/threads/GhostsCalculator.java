package items.moving.ghosts.threads;

import astar.AStar;
import astar.Node;
import frames.PacmanFrame;
import items.Blob;
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

    private Node getPositionFromCoordinates(Blob b){
        int h = b.getX()/36; //X
        int v = ((b.getY() - 20) /39); //Y
        return new Node(h, v);
    }
}

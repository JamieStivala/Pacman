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
        AStar aStar = new AStar(20, 40, this.getPositionFromCoordinates(ghosts.getRed()), this.getPositionFromCoordinates(pacman));
        this.ghosts.getRed().setAStar(aStar);
        aStar = new AStar(20, 40, this.getPositionFromCoordinates(ghosts.getTurquoise()), this.getPositionFromCoordinates(pacman));
        this.ghosts.getTurquoise().setAStar(aStar);
        aStar = new AStar(20, 40, this.getPositionFromCoordinates(ghosts.getYellow()), this.getPositionFromCoordinates(pacman));
        this.ghosts.getPink().setAStar(aStar);
        aStar = new AStar(20, 40, this.getPositionFromCoordinates(ghosts.getPink()), this.getPositionFromCoordinates(pacman));
        this.ghosts.getYellow().setAStar(aStar);
    }

    private Node getPositionFromCoordinates(Blob b){
        int h = b.getX()/36; //X
        int v = ((b.getY() - 20) /39); //Y
        return new Node(h, v);
    }
}

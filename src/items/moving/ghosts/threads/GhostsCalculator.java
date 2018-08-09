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
        AStar aStar = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getRed()), this.getPositionFromCoordinates(pacman));
        aStar.setBlocks(this.wallArray);
        this.ghosts.getRed().setPath(aStar.findPath());

        aStar = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getTurquoise()), this.getPositionFromCoordinates(pacman));
        aStar.setBlocks(this.wallArray);
        this.ghosts.getTurquoise().setPath(aStar.findPath());

        aStar = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getYellow()), this.getPositionFromCoordinates(pacman));
        aStar.setBlocks(this.wallArray);
        this.ghosts.getPink().setPath(aStar.findPath());

        aStar = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getPink()), this.getPositionFromCoordinates(pacman));
        aStar.setBlocks(this.wallArray);
        this.ghosts.getYellow().setPath(aStar.findPath());
    }

    private Node getPositionFromCoordinates(Blob blob){
        int horizontal = blob.getX()/36; //X
        int vertical = ((blob.getY() - 20) /39); //Y
        return new Node(horizontal, vertical);
    }
}

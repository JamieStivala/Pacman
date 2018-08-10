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
        AStar yellow = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getYellow()), this.getPositionFromCoordinates(pacman));
        yellow.setBlocks(this.wallArray);
        this.ghosts.getPink().setPath(yellow.findPath());

        AStar turquoise = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getTurquoise()), this.getPositionFromCoordinates(pacman));
        turquoise.setBlocks(this.wallArray);
        this.ghosts.getTurquoise().setPath(turquoise.findPath());

        AStar red = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getRed()), this.getPositionFromCoordinates(pacman));
        red.setBlocks(this.wallArray);
        this.ghosts.getRed().setPath(red.findPath());


        AStar pink = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getPink()), this.getPositionFromCoordinates(pacman));
        pink.setBlocks(this.wallArray);
        this.ghosts.getYellow().setPath(pink.findPath());
    }

    private Node getPositionFromCoordinates(Blob blob){
        int horizontal = blob.getX()/36; //X
        int vertical = ((blob.getY() - 20) /39); //Y
        return new Node(horizontal, vertical);
    }
}

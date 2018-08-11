package items.moving.ghosts.threads;

import astar.AStar;
import astar.Node;
import frames.PacmanFrame;
import items.Blob;
import items.moving.ghosts.Ghosts;
import items.moving.pacman.Pacman;
import items.moving.pacman.threads.CoinCollisionDetection;

public class GhostsCalculator extends Thread {
    private Ghosts ghosts;
    private Pacman pacman;
    private CoinCollisionDetection coinCollisionDetection;
    private int wallArray[][];

    public GhostsCalculator(PacmanFrame pacmanFrame) {
        this.pacman = pacmanFrame.getPacman();
        this.ghosts = pacmanFrame.getGhosts();
        this.wallArray = pacmanFrame.getMap().getWallArray();
        this.coinCollisionDetection = pacmanFrame.getCoinCollisionDetection();
    }

    @Override
    public void run() {
        AStar aStar;
        if (coinCollisionDetection.getScore() > 2) {
            aStar = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getRed()), this.getPositionFromCoordinates(pacman));
            aStar.setBlocks(this.wallArray);
            this.ghosts.getRed().setPath(aStar.findPath());
            ghosts.setAmountOfGhostsOut(1);
        }

        if (coinCollisionDetection.getScore() > 20) {
            aStar = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getTurquoise()), this.getPositionFromCoordinates(pacman));
            aStar.setBlocks(this.wallArray);
            this.ghosts.getTurquoise().setPath(aStar.findPath());
            ghosts.setAmountOfGhostsOut(2);
        }

        if (coinCollisionDetection.getScore() > 100) {
            aStar = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getYellow()), this.getPositionFromCoordinates(pacman));
            aStar.setBlocks(this.wallArray);
            this.ghosts.getYellow().setPath(aStar.findPath());
            ghosts.setAmountOfGhostsOut(3);
        }

        if (coinCollisionDetection.getScore() > 200) {
            aStar = new AStar(40, 20, this.getPositionFromCoordinates(ghosts.getPink()), this.getPositionFromCoordinates(pacman));
            aStar.setBlocks(this.wallArray);
            this.ghosts.getPink().setPath(aStar.findPath());
            ghosts.setAmountOfGhostsOut(4);
        }
    }

    private Node getPositionFromCoordinates(Blob blob) {
        int horizontal = blob.getX() / 36; //X
        int vertical = ((blob.getY() - 20) / 39); //Y
        return new Node(horizontal, vertical);
    }
}

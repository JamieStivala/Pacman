package game.items.moving.ghosts.threads;

import game.astar.AStar;
import game.astar.Node;
import game.PacmanFrame;
import game.items.Blob;
import game.items.moving.ghosts.Ghosts;
import game.items.moving.pacman.Pacman;
import game.items.moving.pacman.threads.CoinCollisionDetection;

/**
 * This thread will calculate the path of all the ghosts
 */
public class GhostsCalculator extends Thread {
    private Ghosts ghosts;
    private Pacman pacman;
    private CoinCollisionDetection coinCollisionDetection;
    private int wallArray[][];

    /**
     * @param pacmanFrame he game frame that has almost all the objects of the Pacman game
     */
    public GhostsCalculator(PacmanFrame pacmanFrame) {
        this.pacman = pacmanFrame.getPacman();
        this.ghosts = pacmanFrame.getGhosts();
        this.wallArray = pacmanFrame.getMap().getWallArray();
        this.coinCollisionDetection = pacmanFrame.getCoinCollisionDetection();
    }

    /**
     * Calculates the path depending on the score.
     *
     * On running this thread it first checks the amount of score the game has.  If it has >2 (meaning that the game picked one coin)
     * the red ghosts path is calculated.
     *
     * If >20 the turquoise ghost starts to move and the amountOfGhosts is set to 2
     * If >100 the yellow ghost starts to move and the amountOfGhosts is set to 3
     * If >200 the pink ghost starts to move and the amountOfGhosts is set to 4
     */
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

    /**
     * @param blob The coordinates of the blob
     * @return The converted x and y into the horizontal and vertical positions in grid
     */
    private Node getPositionFromCoordinates(Blob blob) {
        int horizontal = blob.getX() / 36; //X
        int vertical = ((blob.getY() - 20) / 39); //Y
        return new Node(horizontal, vertical);
    }
}

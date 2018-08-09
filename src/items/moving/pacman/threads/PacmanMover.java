package items.moving.pacman.threads;

import astar.Node;
import frames.PacmanFrame;
import items.moving.ghosts.Ghost;
import items.moving.ghosts.Ghosts;
import items.moving.ghosts.threads.GhostsCalculator;
import items.moving.pacman.Pacman;
import items.moving.pacman.PacmanRotation;

public class PacmanMover extends Thread {
    private PacmanFrame pacmanFrame;
    private Pacman pacman;
    private Ghosts ghosts;
    private double freqOfMoves = 0;

    public PacmanMover(PacmanFrame pacmanFrame) {
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
        this.ghosts = pacmanFrame.getGhosts();
    }

    @Override
    public void run() {
        while (pacmanFrame.isRunning()) {
            doPacmanMove(pacmanFrame.getPacman().getCurrentRotation());
            renderCoins();
            moveGhosts(0, new Ghost[]{ghosts.getRed(), ghosts.getYellow(), ghosts.getPink(), ghosts.getTurquoise()});
            pacmanFrame.render();
            pacmanFrame.repaint();
            try {
                Thread.sleep(105);
            } catch (InterruptedException e) {
                System.err.println("Interrupted exception: " + e.getMessage());
            }
        }
    }

    private void doPacmanMove(PacmanRotation rotation) {
        if (pacman.getX() < -5 && rotation == PacmanRotation.LEFT) {
            pacman.getArea().setLocation(1423, pacman.getY());
        } else if (pacman.getX() > 1423 && rotation == PacmanRotation.RIGHT) {
            pacman.getArea().setLocation(-5, pacman.getY());
        } else if (pacman.getY() < 17 && rotation == PacmanRotation.UP) {
            pacman.getArea().setLocation(pacman.getX(), 782);
        } else if (pacman.getY() > 782 && rotation == PacmanRotation.DOWN) {
            pacman.getArea().setLocation(pacman.getX(), 17);
        } else if (!pacman.isCollidedWithWall()) {
            if (rotation == PacmanRotation.LEFT) pacman.moveLeft(6);
            else if (rotation == PacmanRotation.RIGHT) pacman.moveRight(6);
            else if (rotation == PacmanRotation.UP) {
                pacman.moveUp(6);
                freqOfMoves += 0.5;
            }
            else if (rotation == PacmanRotation.DOWN){
                pacman.moveDown(6);
                freqOfMoves += 0.5;
            }
        }
        freqOfMoves++;
    }

    private Node lastNode[] = new Node[4];
    private void moveGhost(Ghost ghost, int counter) {
        new GhostsCalculator(this.pacmanFrame).run();
        if(freqOfMoves <= 6) return;
        if (ghost.getPath() == null || ghost.getPath().isEmpty())
            return;

        Node currentNode = ghost.getPath().get(ghost.getChanged());
        if(lastNode != null && ghost.getChanged() + 1 > ghost.getPath().size()  && (currentNode.getCol() == lastNode[counter].getCol() && currentNode.getRow() == lastNode[counter].getRow() || pacman.isCollidedWithWall())){
            ghost.setChanged(ghost.getChanged() + 1);
            currentNode = ghost.getPath().get(ghost.getChanged() + 1);
        }

        int previousPosition[] = getCoordinatesFromPosition(currentNode);
        ghost.getArea().setLocation(previousPosition[0], previousPosition[1]);
        lastNode[counter] = currentNode;

        freqOfMoves = 0;
    }

    private void moveGhosts(int counter, Ghost[] ghosts){
        if(counter == 4) return;
        moveGhost(ghosts[counter], counter);
        moveGhosts(++counter, ghosts);
    }

    private void renderCoins() {
        if (pacmanFrame.getCoinCollisionDetection().hasCoinBeenTaken()) {
            pacmanFrame.getMap().paint();
            pacmanFrame.getCoinCollisionDetection().updatedCoins();
        }
    }

    private int[] getCoordinatesFromPosition(Node x) {
        int h = x.getRow() * 36; //X
        int v = (x.getCol() * 39) + 20; //Y
        return new int[]{h, v};
    }
}

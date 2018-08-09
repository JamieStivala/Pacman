package items.moving.pacman.threads;

import astar.Node;
import frames.PacmanFrame;
import items.moving.ghosts.Ghosts;
import items.moving.ghosts.threads.GhostsCalculator;
import items.moving.pacman.Pacman;
import items.moving.pacman.PacmanRotation;

public class PacmanMover extends Thread {
    private PacmanFrame pacmanFrame;
    private Pacman pacman;
    private Ghosts ghosts;

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
            moveGhosts();
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
            else if (rotation == PacmanRotation.UP) pacman.moveUp(6);
            else if (rotation == PacmanRotation.DOWN) pacman.moveDown(6);
        }
    }

    private int prevPosition = 0;

    private void moveGhosts() {
        new GhostsCalculator(this.pacmanFrame).start();
        if (ghosts.getRed().getPath() == null || ghosts.getRed().getPath().isEmpty() || (pacman.isCollidedWithWall() && prevPosition == this.ghosts.getRed().getPath().size()))
            return;

        if (pacman.isCollidedWithWall())
            this.ghosts.getRed().setChanged(prevPosition++);


        int previousPosition[] = getCoordinatesFromPosition(this.ghosts.getRed().getPath().get(this.ghosts.getRed().getChanged()));
        ghosts.getRed().getArea().setLocation(previousPosition[0], previousPosition[1]);
        prevPosition = this.ghosts.getRed().getChanged();
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

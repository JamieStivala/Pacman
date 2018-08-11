package items.moving.pacman.threads;

import frames.PacmanFrame;
import items.moving.pacman.Pacman;
import map.Line;

import static items.moving.pacman.PacmanRotation.*;

public class OverlappingDetection extends Thread {
    private PacmanFrame pacmanFrame;
    private Pacman pacman;

    public OverlappingDetection(PacmanFrame pacmanFrame) {
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
    }

    @Override
    public void run() {
        while (pacmanFrame.isRunning()) {
            boolean overlaps = false;

            if ((pacman.getCurrentRotation() == LEFT || pacman.getCurrentRotation() == RIGHT) && (pacman.getNextRotation() == UP || pacman.getNextRotation() == DOWN)) {
                for (Line current : pacmanFrame.getMap().getVerticalWallLines()) {
                    if (pacman.getArea().intersectsLine(current.getX(), current.getY(), current.getX1(), current.getY1())) {
                        overlaps = true;
                    }
                }
            } else if ((pacman.getCurrentRotation() == UP || pacman.getCurrentRotation() == DOWN) && (pacman.getNextRotation() == LEFT || pacman.getNextRotation() == RIGHT)) {
                for (Line current : pacmanFrame.getMap().getHorizontalWallLines()) {
                    if (pacman.getArea().intersectsLine(current.getX(), current.getY(), current.getX1(), current.getY1())) {
                        overlaps = true;
                    }
                }
            }

            if (!overlaps || pacman.isCollidedWithWall()) {
                pacman.setCurrentRotation(pacman.getNextRotation());
            }
        }

    }
}

package game.listener;

import game.PacmanFrame;
import game.items.moving.pacman.Pacman;
import game.items.moving.pacman.PacmanRotation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This represent the Pacman Key Listener
 */
public class PacmanKeyListener implements KeyListener {
    private Pacman pacman;
    private PacmanFrame pacmanFrame;

    /**
     * @param pacmanFrame The object of the pacmanFrame which stores most of the objects regarding the game
     */
    public PacmanKeyListener(PacmanFrame pacmanFrame) {
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * When the key pressed it checks which key is pressed and updates the setNextRotation
     * It also triggers the key pressed in getWallCollisionDetection
     * @param e The key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 37 || e.getKeyCode() == 65) pacman.setNextRotation(PacmanRotation.LEFT);
        else if (e.getKeyCode() == 39 || e.getKeyCode() == 68) pacman.setNextRotation(PacmanRotation.RIGHT);
        else if (e.getKeyCode() == 38 || e.getKeyCode() == 87) pacman.setNextRotation(PacmanRotation.UP);
        else if (e.getKeyCode() == 40 || e.getKeyCode() == 83) pacman.setNextRotation(PacmanRotation.DOWN);
        this.pacmanFrame.getWallCollisionDetection().keyPressed();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

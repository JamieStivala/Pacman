package frames.listeners.pacman;

import frames.PacmanFrame;
import items.moving.Pacman;
import items.moving.PacmanRotation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacmanKeyListener implements KeyListener {
    private Pacman pacman;
    private PacmanFrame pacmanFrame;
    public PacmanKeyListener(PacmanFrame pacmanFrame){
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 37 || e.getKeyCode() == 65) pacman.setCurrentRotation(PacmanRotation.LEFT);
        else if(e.getKeyCode() == 39 || e.getKeyCode() == 68) pacman.setCurrentRotation(PacmanRotation.RIGHT);
        else if(e.getKeyCode() == 38 || e.getKeyCode() == 87) pacman.setCurrentRotation(PacmanRotation.UP);
        else if (e.getKeyCode() == 40 || e.getKeyCode() == 83) pacman.setCurrentRotation(PacmanRotation.DOWN);
        this.pacmanFrame.getWallCollisionDetection().keyPressed();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

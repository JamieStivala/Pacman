package listener;

import items.moving.Pacman;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacmanKeyListener implements KeyListener {
    private Pacman pacman;
    private JFrame jFrame;
    public PacmanKeyListener(Pacman pacman, JFrame pacmanFrame){
        this.pacman = pacman;
        this.jFrame = pacmanFrame;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 37 || e.getKeyCode() == 65) pacman.moveLeft(5);
        else if(e.getKeyCode() == 39 || e.getKeyCode() == 68) pacman.moveRight(5);
        else if(e.getKeyCode() == 38 || e.getKeyCode() == 87) pacman.moveUp(5);
        else if (e.getKeyCode() == 40 || e.getKeyCode() == 83) pacman.moveDown(5);

        jFrame.update(jFrame.getGraphics());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

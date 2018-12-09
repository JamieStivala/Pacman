package game.listeners;

import game.PacmanRunner;
import game.map.PacmanMap;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;

public class WindowResize implements ComponentListener, Runnable {
    private PacmanMap pacmanMap;
    private PacmanRunner pacmanRunner;

    public WindowResize(PacmanMap pacmanMap, PacmanRunner pacmanRunner) {
        this.pacmanMap = pacmanMap;
        this.pacmanRunner = pacmanRunner;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        new Thread(this).start();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void run() {
        pacmanRunner.setScreen(new BufferedImage(pacmanRunner.getWidth(), pacmanRunner.getHeight(), BufferedImage.TYPE_INT_ARGB));

        pacmanMap.setScreenWidth(pacmanRunner.getWidth());
        pacmanMap.setScreenHeight(pacmanRunner.getHeight());
        pacmanMap.buildMapObjects();
        pacmanMap.renderMap();

        pacmanRunner.render();
        pacmanRunner.paint(this.pacmanRunner.getGraphics());
    }
}

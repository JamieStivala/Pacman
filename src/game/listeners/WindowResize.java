package game.listeners;

import game.PacmanFrame;
import game.map.PacmanMap;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;

public class WindowResize implements ComponentListener, Runnable {
    private PacmanMap pacmanMap;
    private PacmanFrame pacmanFrame;

    public WindowResize(PacmanMap pacmanMap, PacmanFrame pacmanFrame) {
        this.pacmanMap = pacmanMap;
        this.pacmanFrame = pacmanFrame;
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
        pacmanFrame.setScreen(new BufferedImage(pacmanFrame.getWidth(), pacmanFrame.getHeight(), BufferedImage.TYPE_INT_ARGB));

        pacmanMap.setScreenWidth(pacmanFrame.getWidth());
        pacmanMap.setScreenHeight(pacmanFrame.getHeight());
        pacmanMap.buildMapObjects();
        pacmanMap.renderMap();

        pacmanFrame.render();
        pacmanFrame.paint(this.pacmanFrame.getGraphics());
    }
}

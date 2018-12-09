package game.listeners;

import game.PacmanFrame;
import game.map.PacmanMap;

import java.awt.*;
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
        Insets dimension = pacmanFrame.getInsets();

        pacmanMap.setScreenWidth(pacmanFrame.getWidth());
        pacmanMap.setScreenHeight(pacmanFrame.getHeight(), dimension.top);
        pacmanMap.buildMapObjects();
        pacmanMap.renderMap();

        pacmanFrame.render();
        pacmanFrame.repaint();
    }
}
package game;

import game.listeners.WindowResize;
import game.map.PacmanMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PacmanRunner extends JFrame {
    private PacmanMap pacmanMap;
    private BufferedImage screen;

    public PacmanRunner() {
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.pacmanMap = new PacmanMap(20, 40, 1440, 900);
        this.screen = new BufferedImage(1440, 900, BufferedImage.TYPE_INT_ARGB);

        this.addComponentListener(new WindowResize(pacmanMap, this));
        this.setSize(900, 900);
        this.repaint();
        this.setVisible(true);
    }

    public void render() {
        Graphics g = screen.getGraphics();
        g.setColor(new Color(5, 19, 28));
        g.fillRect(1, 1, screen.getWidth(), screen.getHeight());
        g.drawImage(pacmanMap.getRenderedMap(), 1, 1, screen.getWidth(), screen.getHeight(), null);
    }

    @Override
    public void paint(Graphics g) {
        if (screen == null) return;
        g.drawImage(screen, 1, 1, null);
    }

    /**
     * The update calls the paint()
     *
     * @param g the graphics from java.awt
     */
    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void setScreen(BufferedImage image) {
        this.screen = image;
    }
}

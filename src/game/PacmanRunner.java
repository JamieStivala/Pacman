package game;

import game.map.PacmanMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PacmanRunner extends JFrame {
    private PacmanMap pacmanMap;
    private BufferedImage screen;

    PacmanRunner() {
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.pacmanMap = new PacmanMap(20, 40, 1440, 900);
        this.setSize(900, 900);
        this.screen = pacmanMap.getRenderedMap();
        this.repaint();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new PacmanRunner();
    }

    @Override
    public void paint(Graphics g) {
        if (screen == null) return;
        g.drawImage(screen, 1, 1, null);
    }
}

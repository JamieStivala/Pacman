package game;

import game.map.PacmanMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PacmanRunner extends JFrame {
    PacmanMap pacmanMap = new PacmanMap(20, 40, 1440, 900);
    private BufferedImage screen;

    PacmanRunner() {
        this.setVisible(true);
        this.setSize(1440, 900);
        this.setLayout(null);

        this.screen = pacmanMap.getRenderedMap();
        this.repaint();
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

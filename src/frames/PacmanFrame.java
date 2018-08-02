package frames;

import frames.listeners.pacman.PacmanKeyListener;
import frames.listeners.pacman.PacmanWindowListener;
import items.moving.Pacman;
import map.PacmanMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PacmanFrame extends JFrame{
    private PacmanMap map;
    private Pacman pacman;
    private BufferedImage screen;

    public PacmanFrame(){
        map = new PacmanMap(937870171);
        pacman = new Pacman(2, 24);
        screen = new BufferedImage(1440, 799, BufferedImage.TYPE_INT_ARGB);

        super.setTitle("Pacman");
        super.setSize(1440, 799);
        super.setResizable(true);
        super.addWindowListener(new PacmanWindowListener());
        super.addKeyListener(new PacmanKeyListener(pacman, this));
        super.setBackground(new Color(5, 19, 28));
        super.setLayout(null);
        super.setVisible(true);

        this.render();
        this.repaint();
    }

    public void render() {
        Graphics g = screen.getGraphics();
        g.setColor(new Color(5, 19, 28));
        g.fillRect(1, 1, screen.getWidth(), screen.getHeight());
        map.paint(g);
        pacman.paint(g);
    }

    @Override
    public void paint(Graphics g){
        if(screen == null) return;
        g.drawImage(screen, 1, 1, null);
    }

    @Override
    public void update(Graphics g){
        paint(g);
    }
}
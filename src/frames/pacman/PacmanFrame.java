package frames.pacman;

import frames.pacman.listeners.PacmanKeyListener;
import frames.pacman.listeners.PacmanWindowListener;
import items.moving.Pacman;
import items.moving.threads.PacmanMover;
import map.PacmanMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PacmanFrame extends JFrame{
    private PacmanMap map;
    private Pacman pacman;
    private BufferedImage pacmanMap;
    private PacmanMover pacmanMover;
    private BufferedImage screen;

    public PacmanFrame(){
        this.map = new PacmanMap(937870171);
        this.pacman = new Pacman(2, 24);
        this.screen = new BufferedImage(1440, 799, BufferedImage.TYPE_INT_ARGB);

        this.pacmanMap = new BufferedImage(1440, 799, BufferedImage.TYPE_INT_ARGB);
        map.paint(pacmanMap.getGraphics());

        this.pacmanMover = new PacmanMover(this);
        pacmanMover.start();

        super.setTitle("Pacman");
        super.setSize(1440, 799);
        super.setResizable(true);
        super.addWindowListener(new PacmanWindowListener());
        super.addKeyListener(new PacmanKeyListener(pacman, this));
        super.setBackground(new Color(5, 19, 28));
        super.setLayout(null);
        super.setVisible(true);
        super.requestFocus();

        this.render();
        this.repaint();
    }

    public void render() {
        Graphics g = screen.getGraphics();
        g.setColor(new Color(5, 19, 28));
        g.fillRect(1, 1, screen.getWidth(), screen.getHeight());
        g.drawImage(pacmanMap, 1, 1, screen.getWidth(), screen.getHeight(), null);
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

    public Pacman getPacman() {
        return pacman;
    }

    public PacmanMover getPacmanMover() {
        return pacmanMover;
    }
}
package frames;

import frames.listeners.pacman.PacmanKeyListener;
import frames.listeners.pacman.PacmanWindowListener;
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
    private volatile boolean stopped;

    public PacmanFrame(){
        this.map = new PacmanMap(937870171);
        this.pacman = new Pacman(2, 24);
        this.screen = new BufferedImage(1440, 799, BufferedImage.TYPE_INT_ARGB);
        this.setStopped(false);

        this.pacmanMap = new BufferedImage(1440, 799, BufferedImage.TYPE_INT_ARGB);
        map.paint(pacmanMap.getGraphics());

        setFrameSettings();
        startThreads();
    }

    private void setFrameSettings(){
        super.setTitle("Pacman");
        super.setSize(1440, 799);
        super.setResizable(true);
        super.addWindowListener(new PacmanWindowListener());
        super.addKeyListener(new PacmanKeyListener(pacman, this));
        super.setLayout(null);
        super.setVisible(true);
        super.requestFocus();
    }

    private void startThreads(){
        this.pacmanMover = new PacmanMover(this);
        this.pacmanMover.start();
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

    public boolean isRunning() {
        return !stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public PacmanMap getMap() {
        return map;
    }
}
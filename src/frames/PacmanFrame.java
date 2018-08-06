package frames;

import frames.listeners.pacman.PacmanKeyListener;
import items.moving.Pacman;
import items.moving.threads.PacmanMover;
import map.CoinCollisionDetection;
import map.PacmanMap;
import map.WallCollisionDetection;
import user.manager.User;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PacmanFrame extends JFrame{
    private PacmanMap map;
    private Pacman pacman;
    private PacmanMover pacmanMover;
    private WallCollisionDetection wallCollisionDetection;
    private CoinCollisionDetection coinCollisionDetection;
    private BufferedImage screen;
    private volatile boolean stopped;

    PacmanFrame(User user){
        this(user, (long) (Math.random() * 1000000000));
    }

    PacmanFrame(User user, long seed){
        this.map = new PacmanMap(seed);
        this.pacman = new Pacman(2, 24);
        this.screen = new BufferedImage(1440, 799, BufferedImage.TYPE_INT_ARGB);
        this.setStopped(false);

        setFrameSettings();
        startThreads();
    }

    private void setFrameSettings(){
        super.setTitle("Pacman");
        super.setSize(1440, 799);
        super.setResizable(true);
        super.addKeyListener(new PacmanKeyListener(this));
        super.setLayout(null);
        super.setVisible(true);
        super.requestFocus();
    }

    private void startThreads(){
        this.coinCollisionDetection = new CoinCollisionDetection(this);
        this.coinCollisionDetection.start();

        this.pacmanMover = new PacmanMover(this);
        this.pacmanMover.start();

        this.wallCollisionDetection = new WallCollisionDetection(this);
        this.wallCollisionDetection.start();
    }

    public void render() {
        Graphics g = screen.getGraphics();
        g.setColor(new Color(5, 19, 28));
        g.fillRect(1, 1, screen.getWidth(), screen.getHeight());
        g.drawImage(map.getBufferedMap(), 1, 1, screen.getWidth(), screen.getHeight(), null);
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

    public WallCollisionDetection getWallCollisionDetection() {
        return wallCollisionDetection;
    }

    public CoinCollisionDetection getCoinCollisionDetection() {
        return coinCollisionDetection;
    }
}
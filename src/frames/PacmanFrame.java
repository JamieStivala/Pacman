package frames;

import frames.listeners.pacman.PacmanKeyListener;
import items.moving.GeneralMover;
import items.moving.ghosts.Ghosts;
import items.moving.ghosts.threads.GhostsCollisionDetection;
import items.moving.pacman.Pacman;
import items.moving.pacman.threads.CoinCollisionDetection;
import items.moving.pacman.threads.OverlappingDetector;
import items.moving.pacman.threads.WallCollisionDetection;
import map.PacmanMap;
import sounds.pacman.GameStart;
import user.manager.User;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PacmanFrame extends JFrame {
    private PacmanMap map;
    private Pacman pacman;
    private User user;
    private GeneralMover generalMover;
    private WallCollisionDetection wallCollisionDetection;
    private CoinCollisionDetection coinCollisionDetection;
    private OverlappingDetector overlappingDetector;
    private GhostsCollisionDetection ghostsCollisionDetection;
    private Ghosts ghosts;

    private BufferedImage screen;
    private volatile boolean stopped;

    public PacmanFrame(User user) {
        this(user, (long) (Math.random() * 1000000000));
    }

    PacmanFrame(User user, long seed) {
        this.map = new PacmanMap(seed);
        this.user = user;
        this.ghosts = new Ghosts();
        profileFlags(seed);
        this.pacman = new Pacman(0, 24);
        this.screen = new BufferedImage(1440, 799, BufferedImage.TYPE_INT_ARGB);

        this.setStopped(false);
        new GameStart().start();

        setFrameSettings();
        startThreads();
    }

    private void profileFlags(long seed) {
        boolean found = false;
        for (int i = 0; i != user.getSeedsPlayed().size(); i++) {
            if (user.getSeedsPlayed().get(i) == seed) found = true;
        }
        if (!found) user.getSeedsPlayed().add(0, seed);
        user.incrementTotalPlayedGamed();
    }

    private void setFrameSettings() {
        super.setTitle("Pacman");
        super.setSize(1440, 799);
        super.setResizable(false);
        super.addKeyListener(new PacmanKeyListener(this));
        super.setLayout(null);
        super.setVisible(true);
        super.requestFocus();
    }

    private void startThreads() {
        this.coinCollisionDetection = new CoinCollisionDetection(this);
        this.coinCollisionDetection.start();

        this.generalMover = new GeneralMover(this);
        this.generalMover.start();

        this.wallCollisionDetection = new WallCollisionDetection(this);
        this.wallCollisionDetection.start();

        this.overlappingDetector = new OverlappingDetector(this);
        this.overlappingDetector.start();

        this.ghostsCollisionDetection = new GhostsCollisionDetection(this);
        this.ghostsCollisionDetection.start();
    }

    public void render() {
        Graphics g = screen.getGraphics();
        g.setColor(new Color(5, 19, 28));
        g.fillRect(1, 1, screen.getWidth(), screen.getHeight());
        g.drawImage(map.getBufferedMap(), 1, 1, screen.getWidth(), screen.getHeight(), null);
        pacman.paint(g);
        ghosts.paint(g);
    }

    @Override
    public void paint(Graphics g) {
        if (screen == null) return;
        g.drawImage(screen, 1, 1, null);
    }

    @Override
    public void update(Graphics g) {
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

    public User getUser() {
        return user;
    }

    public Ghosts getGhosts() {
        return ghosts;
    }
}